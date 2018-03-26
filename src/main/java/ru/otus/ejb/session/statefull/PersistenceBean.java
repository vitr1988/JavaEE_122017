package ru.otus.ejb.session.statefull;

import ru.otus.ejb.session.singleton.EmployeeCacheable;
import ru.otus.jdbc.model.EmpEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful(passivationCapable = false)
@Remote(EmployeeManageable.class)
public class PersistenceBean implements EmployeeManageable{

    @PersistenceContext(unitName = "jpa")
    EntityManager manager;

    @EJB
    EmployeeCacheable cache;

    private String status = "INITIAL";

    @PostConstruct
    public void init(){
        //
    }

    @PreDestroy
    public void destroy(){
        //
    }

    public String getEmployeeName(Long id){
        EmpEntity employee =  manager.find(EmpEntity.class, id);
        String name = employee.getEname();
        cache.put(id, name);
        return name;
    }

    public void createAndUpdateEmployee(){
        status = "READY";
    }


    @PrePassivate
    @Remove
    public void commit(){
        if (!"READY".equalsIgnoreCase(status)) {
            throw new RuntimeException("You can't be here");
        }
    }
}
