package ru.otus.ejb.session;

import ru.otus.jdbc.model.EmpEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceBean {

    @PersistenceContext(unitName = "jpa")
    EntityManager manager;

    public String getEmployeeName(Integer id){
        EmpEntity employee =  manager.find(EmpEntity.class, id);
        return employee.getEname();
    }
}
