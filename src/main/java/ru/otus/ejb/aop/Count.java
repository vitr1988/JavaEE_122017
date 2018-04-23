package ru.otus.ejb.aop;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.security.Principal;

@Stateful
@Interceptors({Logger.class/*, Logger.class*/})
@DeclareRoles("MANAGER")
@RunAs("ADMIN")
public class Count implements Serializable {

    @Resource
    SessionContext context;

    int count = 1;

//    @Interceptors(Logger.class)
    public int getResult() {
        Principal principal = context.getCallerPrincipal();
        if (context.isCallerInRole("ADMIN")) {

        }
        return count;
    }

    @RolesAllowed({"ADMIN", "MANAGER"})
    public void increment(){
        count++;
    }

}
