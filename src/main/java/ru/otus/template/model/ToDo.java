package ru.otus.template.model;

import java.util.Date;

public class ToDo {
    private String user;
    private Date currentDate;
    private String text;

    public ToDo() {
    }

    public ToDo(String user, Date currentDate, String text) {
        this.user = user;
        this.currentDate = currentDate;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
