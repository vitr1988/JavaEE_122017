package ru.otus.ejb.aop;

import javax.ejb.Stateless;

@Stateless
@Auditable
public class AuditEJB {

    public String bizMethod(){
        //any calls to this method will be intercepted by AuditInterceptor.audit()
        return "Your ads could be here";
    }
}
