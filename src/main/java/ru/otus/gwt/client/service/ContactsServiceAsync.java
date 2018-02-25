package ru.otus.gwt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.otus.gwt.shared.model.Contact;
import ru.otus.gwt.shared.model.ContactDetails;

import java.util.ArrayList;

public interface ContactsServiceAsync {

  public void addContact(Contact contact, AsyncCallback<Contact> callback);
  public void deleteContact(String id, AsyncCallback<Boolean> callback);
  public void deleteContacts(ArrayList<String> ids, AsyncCallback<ArrayList<ContactDetails>> callback);
  public void getContactDetails(AsyncCallback<ArrayList<ContactDetails>> callback);
  public void getContact(String id, AsyncCallback<Contact> callback);
  public void updateContact(Contact contact, AsyncCallback<Contact> callback);
}

