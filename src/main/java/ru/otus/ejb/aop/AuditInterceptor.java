package ru.otus.ejb.aop;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
public class AuditInterceptor {

    @AroundInvoke
    public Object audit(InvocationContext ictx) throws Exception {
        //logic goes here
        return ictx.proceed();
    }
}
