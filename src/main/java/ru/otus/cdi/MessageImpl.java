package ru.otus.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;

@RequestScoped
@Default
public class MessageImpl implements Message {

    @Override
    public String get() {
        return "Hello World";
    }
}
