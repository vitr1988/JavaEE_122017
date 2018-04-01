package ru.otus.ejb.aop;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    @AroundInvoke
    public Object addLog(InvocationContext context) throws Exception {
        //какая-то логика логирования
        System.out.println("Operation has been fixed at " + DATE_TIME_FORMATTER.format(LocalDateTime.now()));
        return context.proceed();
    }

    @PostConstruct
    public void init(InvocationContext context) throws Exception {
        //логирование создания объекта, например через context.getTarget()
        context.proceed();
    }

    @PreDestroy
    public void remove(InvocationContext context) throws Exception {
        //какая-то логика
        context.proceed();
    }
}