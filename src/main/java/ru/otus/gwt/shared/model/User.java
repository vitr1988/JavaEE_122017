package ru.otus.gwt.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class User implements IsSerializable {

    private String login;
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = String.valueOf(password);
    }
}
