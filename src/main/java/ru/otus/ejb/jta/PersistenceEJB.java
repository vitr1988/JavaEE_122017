package ru.otus.ejb.jta;

import ru.otus.ejb.session.statefull.EmpEntity;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateful
@TransactionAttribute(TransactionAttributeType.NEVER)
public class PersistenceEJB {

    @PersistenceContext(unitName = "jpa", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void changeName() {
        // changes will not be committed
        // because there is no active transaction
        EmpEntity employee = entityManager.find(EmpEntity.class, 7935);
        employee.setEname("Mark");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void commit() {
        // changes will be committed here because
        // there is an active transaction and
        // pending changes exist in managed entities
        // (Employee with ID=4 name was changed)
    }
}
