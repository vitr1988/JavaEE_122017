package ru.otus.ejb.session.client;

import ru.otus.ejb.session.statefull.EmployeeManageable;
import ru.otus.ejb.session.stateless.SimpleBean;

import javax.naming.InitialContext;

public class EJBClient {
    public static void main(String[] args) throws Exception {
        InitialContext context = new InitialContext();
        SimpleBean bean = (SimpleBean) context.lookup("java:global/JavaEE_122017-1.0-SNAPSHOT/SimpleBean!ru.otus.ejb.session.stateless.SimpleBean");
        //work with interface.. not implementation (proxy)
        EmployeeManageable dataBean = (EmployeeManageable) context.lookup("java:global/JavaEE_122017-1.0-SNAPSHOT/PersistenceBean!ru.otus.ejb.session.statefull.EmployeeManageable");
//        SimpleBean bean2 = (SimpleBean) context.lookup("java:app/JavaEE_122017-1.0-SNAPSHOT/Example!ru.otus.ejb.session.SimpleBean");
//        SimpleBean bean3 = (SimpleBean) context.lookup("java:module/Example!ru.otus.ejb.session.SimpleBean");

        String result = bean.sayHello("World!");
        System.out.println(result);

        String data = dataBean.getEmployeeName(7936L);
        System.out.println(data);
    }
}
