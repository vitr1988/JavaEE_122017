package ru.otus.ejb.session.stateless;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name="SimpleBean", mappedName = "ejb/SimpleBean")
public class SimpleBeanImpl implements SimpleBean {

    @Resource
    SessionContext context;

    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
