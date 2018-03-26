package ru.otus.ejb.session.client;

//import ru.otus.ejb.session.stateless.SimpleBean;

import ru.otus.ejb.session.stateless.SimpleBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

public class JNDIClient {

    private static InitialContext ctx;

    static {
        Properties props = new Properties();
        try {
            props.load(JNDIClient.class.getResourceAsStream("/jndi.properties"));
            ctx = new InitialContext(props);
        } catch (IOException | NamingException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleBean bean = (SimpleBean) ctx.lookup("ejb/SimpleBean");
        System.out.println(bean.sayHello("there"));
    }
}