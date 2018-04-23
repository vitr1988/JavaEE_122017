package ru.otus.ejb.aop;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;

@Stateless
@Auditable
@PermitAll
public class AuditEJB {

    public String bizMethod(){
        //any calls to this method will be intercepted by AuditInterceptor.audit()
        return "Your ads could be here";
    }
}
