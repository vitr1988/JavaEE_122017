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
public class TransactionPersistenceContextEJB {
    @PersistenceContext(unitName = "jpa", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void methodOne() {

        EmpEntity employee = entityManager.find(EmpEntity.class, 7936);

        // true
        boolean contains = entityManager.contains(employee);

        // does not issue a second query
        EmpEntity other = entityManager.find(EmpEntity.class, 7937);

        // true
        boolean equal = (employee == other);

    }

    public void methodTwo() {

        // does not issue a second query
        // if called after methodOne
        // since the entity is already managed
        EmpEntity employee = entityManager.find(EmpEntity.class, 7936);

        // true
        boolean contains = entityManager.contains(employee);

    }
}
