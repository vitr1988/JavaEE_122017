package ru.otus.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import ru.otus.gwt.client.event.*;
import ru.otus.gwt.client.presenter.ContactsPresenter;
import ru.otus.gwt.client.presenter.EditContactPresenter;
import ru.otus.gwt.client.presenter.Presenter;
import ru.otus.gwt.client.service.ContactsServiceAsync;
import ru.otus.gwt.client.view.ContactsViewImpl;
import ru.otus.gwt.client.view.EditContactViewImpl;

public class AppController implements Presenter, ValueChangeHandler<String> {
  private final HandlerManager eventBus;
  private final ContactsServiceAsync rpcService;
  private HasWidgets container;
  private ContactsViewImpl contactsView = null;
  private EditContactViewImpl editContactView = null;

  public AppController(ContactsServiceAsync rpcService,
                       HandlerManager eventBus) {
    this.eventBus = eventBus;
    this.rpcService = rpcService;
    bind();
  }

  private void bind() {
    History.addValueChangeHandler(this);

    eventBus.addHandler(AddContactEvent.TYPE,
            new AddContactEventHandler() {
              public void onAddContact(AddContactEvent event) {
                doAddNewContact();
              }
            });

    eventBus.addHandler(EditContactEvent.TYPE,
            new EditContactEventHandler() {
              public void onEditContact(EditContactEvent event) {
                doEditContact(event.getId());
              }
            });

    eventBus.addHandler(EditContactCancelledEvent.TYPE,
            new EditContactCancelledEventHandler() {
              public void onEditContactCancelled(EditContactCancelledEvent event) {
                doEditContactCancelled();
              }
            });

    eventBus.addHandler(ContactUpdatedEvent.TYPE,
            new ContactUpdatedEventHandler() {
              public void onContactUpdated(ContactUpdatedEvent event) {
                doContactUpdated();
              }
            });
  }

  private void doAddNewContact() {
    History.newItem("add");
  }

  private void doEditContact(String id) {
    History.newItem("edit", false);
    Presenter presenter = new EditContactPresenter(rpcService, eventBus,
            new EditContactViewImpl(), id);
    presenter.go(container);
  }

  private void doEditContactCancelled() {
    History.newItem("list");
  }

  private void doContactUpdated() {
    History.newItem("list");
  }

  public void go(final HasWidgets container) {
    this.container = container;

    if ("".equals(History.getToken())) {
      History.newItem("list");
    }
    else {
      History.fireCurrentHistoryState();
    }
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();

    if (token != null) {
      if (token.equals("list")) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable caught) {
          }

          public void onSuccess() {
            // lazily initialize our views, and keep them around to be reused
            //
            if (contactsView == null) {
              contactsView = new ContactsViewImpl();

            }
            new ContactsPresenter(rpcService, eventBus, new ContactsViewImpl()).go(container);
          }
        });
      }
      else if (token.equals("add") || token.equals("edit")) {
        GWT.runAsync(new RunAsyncCallback() {
          public void onFailure(Throwable caught) {
          }

          public void onSuccess() {
            // lazily initialize our views, and keep them around to be reused
            //
            if (editContactView == null) {
              editContactView = new EditContactViewImpl();

            }
            new EditContactPresenter(rpcService, eventBus, editContactView).
                    go(container);
          }
        });
      }
    }
  }
}
