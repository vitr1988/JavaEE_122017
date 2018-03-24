package ru.otus.ejb.session;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="Example", mappedName="ejb/SimpleBeanJNDI")
public class SimpleBeanImpl implements SimpleBean {

    @Resource
    SessionContext context;

    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
