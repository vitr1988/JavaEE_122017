package ru.otus.ejb.aop;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Count implements Serializable {

    @Interceptors(Logger.class)
    public String getResult() {
        return null;
    }

}
