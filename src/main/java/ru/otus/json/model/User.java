package ru.otus.json.model;

public class User {

    private String login;
    private String password;

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
