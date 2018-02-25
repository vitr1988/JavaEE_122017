package ru.otus.gwt.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import ru.otus.gwt.client.presenter.EditContactPresenter;

import static ru.otus.gwt.client.dictionary.Constants.RESOURCE;

public class EditContactViewImpl extends Composite implements EditContactPresenter.Display {

  @UiTemplate("EditContactView.ui.xml")
  interface EditContactView extends UiBinder<DecoratorPanel, EditContactViewImpl> {
  }
  private static EditContactView uiBinder = GWT.create(EditContactView.class);

  @UiField TextBox firstName;

  @UiField TextBox lastName;
  @UiField TextBox emailAddress;

  @UiField FlexTable detailsTable;
  @UiField Button saveButton;
  @UiField Button cancelButton;
  
  public EditContactViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
    initDetailsTable();
  }
  
  private void initDetailsTable() {
    detailsTable.setWidget(0, 0, new Label(RESOURCE.firsName_label_alt()));
    detailsTable.setWidget(0, 1, firstName);
    detailsTable.setWidget(1, 0, new Label(RESOURCE.lastName_label_alt()));
    detailsTable.setWidget(1, 1, lastName);
    detailsTable.setWidget(2, 0, new Label(RESOURCE.email_label_alt()));
    detailsTable.setWidget(2, 1, emailAddress);
    firstName.setFocus(true);
  }
  
  public HasValue<String> getFirstName() {
    return firstName;
  }

  public HasValue<String> getLastName() {
    return lastName;
  }

  public HasValue<String> getEmailAddress() {
    return emailAddress;
  }

  public HasClickHandlers getSaveButton() {
    return saveButton;
  }
  
  public HasClickHandlers getCancelButton() {
    return cancelButton;
  }
  
  public Widget asWidget() {
    return this;
  }
}
