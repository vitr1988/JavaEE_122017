package ru.otus.ejb.aop;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.io.Serializable;

@Stateful
public class Count implements Serializable {

    int count = 1;

    @Interceptors(Logger.class)
    public int getResult() {
        return count;
    }

    public void increment(){
        count++;
    }

}
