package ru.otus.ejb.session.embeddable;

import javax.ejb.Stateless;

@Stateless
public class App {
    public static String sayHello(String name) {
        return "Hello " + name;
    }
}
