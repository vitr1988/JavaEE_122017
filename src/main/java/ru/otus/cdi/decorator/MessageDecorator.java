package ru.otus.cdi.decorator;

import ru.otus.cdi.Message;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class MessageDecorator implements Message {

    @Inject
    @Delegate
    @Any
    Message message;

    @Override
    public String get() {
        return "this decorator string: " + message.get();
    }
}
