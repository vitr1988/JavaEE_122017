package ru.otus.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.otus.gwt.client.service.MySampleApplicationService;
import ru.otus.gwt.shared.exception.WrongCredentialException;
import ru.otus.gwt.shared.model.User;

import java.util.Objects;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    @Override
    public void authorize(User user) throws WrongCredentialException {
        if (!Objects.equals(user.getLogin(), user.getPassword())) {
            throw new WrongCredentialException("Некорректные логин/пароль");
        }
    }
}