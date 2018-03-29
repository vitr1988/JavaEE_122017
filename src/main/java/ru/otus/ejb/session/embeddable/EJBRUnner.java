package ru.otus.ejb.session.embeddable;

import ru.otus.ejb.session.stateless.SimpleBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

public class EJBRUnner {

    public static void main(String[] args) throws Exception {
        try (EJBContainer container = EJBContainer.createEJBContainer()) {
            Context ctx = container.getContext();
            App sb = (App) ctx.lookup("java:global/classes/App");
            //TODO..
        }
    }
}
