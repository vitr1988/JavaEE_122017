package ru.otus.ejb.aop;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
@Priority(10)
public class AuditInterceptor {

    @AroundInvoke
    public Object audit(InvocationContext ictx) throws Exception {
        //before
        //logic goes here
        Object result = ictx.proceed();
        //after
        return result;
    }
}
