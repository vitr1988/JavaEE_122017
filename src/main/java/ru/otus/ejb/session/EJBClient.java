package ru.otus.ejb.session;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class EJBClient {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(EJBClient.class.getResourceAsStream("/jndi.properties"));
//        InitialContext ctx = new InitialContext(props);
        InitialContext ctx = new InitialContext();
        SimpleBean bean = (SimpleBean) ctx.lookup("ejb/SimpleBeanJNDI");
        String result = bean.sayHello("Billy Bob");
        System.out.println(result);
    }
}
