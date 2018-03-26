package ru.otus.ejb.session.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionFactory {

    private static class TransactionInvocationHandler<D> implements InvocationHandler {

        private final D dao;

        private final String dataSourceJndiName;

        private final String moduleName;

        public TransactionInvocationHandler(D dao, String dataSourceJndiName, String moduleName) {
            this.dao = dao;
            this.dataSourceJndiName = dataSourceJndiName;
            this.moduleName = moduleName;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class<?> daoClass = dao.getClass();
            Method implementingMethod = daoClass.getMethod(
                    method.getName(), method.getParameterTypes());
            System.out.println("Origin Class :" + daoClass.getName());
            return method.invoke(dao, args);
        }
    }

    @SuppressWarnings("unchecked")
    public static <D> D createProxy(D dao, String dataSourceJndiName, String moduleName) {
        Class<?> daoClass = dao.getClass();
        return (D) Proxy.newProxyInstance(
                TransactionFactory.class.getClassLoader(),
                daoClass.getInterfaces(),
                new TransactionInvocationHandler<D>(dao, dataSourceJndiName, moduleName));
    }
}

