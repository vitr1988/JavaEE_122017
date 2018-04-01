package ru.otus.ejb.aop.exception;

import org.hibernate.JDBCException;

public class Repository {
    public Object getSomeData() {
        // simulate hibernate error
        throw new JDBCException("Error", null);
    }
}
