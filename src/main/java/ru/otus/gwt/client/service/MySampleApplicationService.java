package ru.otus.gwt.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.otus.gwt.shared.exception.WrongCredentialException;
import ru.otus.gwt.shared.model.User;

@RemoteServiceRelativePath("MySampleApplicationService")
public interface MySampleApplicationService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);
    void authorize(User user) throws WrongCredentialException;
}
