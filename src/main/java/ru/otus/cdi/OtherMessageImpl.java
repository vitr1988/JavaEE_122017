package ru.otus.cdi;

import javax.enterprise.inject.Alternative;

@Alternative
public class OtherMessageImpl implements Message {
    @Override
    public String get() {
        return "Hi there";
    }
}
