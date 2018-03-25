package ru.otus.ejb.session.stateless;

import javax.ejb.Remote;

@Remote
public interface SimpleBean {
    String sayHello(String name);
}
