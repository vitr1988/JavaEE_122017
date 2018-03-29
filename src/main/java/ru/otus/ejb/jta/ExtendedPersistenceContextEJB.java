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
public class ExtendedPersistenceContextEJB {

    @PersistenceContext(unitName = "jpa")
    private EntityManager entityManager;

    public EmpEntity loadEmployee(Long id) {

        EmpEntity employee = entityManager.find(EmpEntity.class, id);

        // false
        boolean contains = entityManager.contains(employee);

        // will issue a second query
        EmpEntity other = entityManager.find(EmpEntity.class, id);

        // false
        boolean equal = (employee == other);

        return employee;
    }
}
