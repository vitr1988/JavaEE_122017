package ru.otus.ejb.aop.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.HibernateException;

@Aspect
public class HibernateExceptionAspect {
    @Around("execution(* ru.otus.ejb.aop.exception..*(..))")
    public Object translateToDataAccessException(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (HibernateException e) {
            throw new RuntimeException("Test: " + e.getLocalizedMessage());
        }
    }
}
