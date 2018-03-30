package ru.otus.ejb.aop;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Logger {
    @AroundInvoke
    public Object addLog(InvocationContext context) {
        //какая-то логика логирования
        return context.proceed();
    }

    @PostConstruct
    public void init(InvocationContext context){
        //логирование создания объекта, например через context.getTarget()
        context.proceed();
    }

    @PreDestroy
    public void remove(InvocationContext context){
        //какая-то логика
        context.proceed();
    }
}