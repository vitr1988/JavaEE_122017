package ru.otus.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import ru.otus.gwt.client.service.ContactsService;
import ru.otus.gwt.client.service.ContactsServiceAsync;

public class Contacts implements EntryPoint {

  public void onModuleLoad() {
    ContactsServiceAsync rpcService = GWT.create(ContactsService.class);
    HandlerManager eventBus = new HandlerManager(null);
    AppController appViewer = new AppController(rpcService, eventBus);
    appViewer.go(RootPanel.get());
  }
}
