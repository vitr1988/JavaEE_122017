package ru.otus.ejb.session;

import javax.ejb.Remote;

@Remote
public interface SimpleBean {
    String sayHello(String name);
}
