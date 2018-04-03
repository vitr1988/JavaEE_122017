package ru.otus.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MessageImpl implements Message {

    @Override
    public String get() {
        return "Hello World";
    }
}
