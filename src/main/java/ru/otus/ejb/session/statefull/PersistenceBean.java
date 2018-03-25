package ru.otus.ejb.session.statefull;

import ru.otus.ejb.session.singleton.EmployeeCacheable;
import ru.otus.jdbc.model.EmpEntity;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Remote(EmployeeManageable.class)
public class PersistenceBean implements EmployeeManageable{

    @PersistenceContext(unitName = "jpa")
    EntityManager manager;

    @EJB
    EmployeeCacheable cache;

    public String getEmployeeName(Long id){
        EmpEntity employee =  manager.find(EmpEntity.class, id);
        String name = employee.getEname();
        cache.put(id, name);
        return name;
    }
}
