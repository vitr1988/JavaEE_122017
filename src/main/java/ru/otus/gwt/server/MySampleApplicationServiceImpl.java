package ru.otus.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.otus.gwt.client.service.MySampleApplicationService;
import ru.otus.gwt.shared.model.User;

import java.util.Objects;

public class MySampleApplicationServiceImpl extends RemoteServiceServlet implements MySampleApplicationService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    @Override
    public Boolean authorize(User user) {
        return Objects.equals(user.getLogin(), user.getPassword());
    }
}