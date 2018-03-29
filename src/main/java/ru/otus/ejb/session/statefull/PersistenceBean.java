package ru.otus.ejb.session.statefull;

import ru.otus.ejb.session.singleton.EmployeeCacheable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.RollbackException;
import javax.transaction.*;

@Stateful(passivationCapable = false)
@Remote(EmployeeManageable.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PersistenceBean implements EmployeeManageable{

    @PersistenceContext(unitName = "jpa")
    EntityManager manager;

    @PersistenceUnit(unitName = "jpa")
    EntityManagerFactory managerFactory;

    @EJB
    EmployeeCacheable cache;

    @Resource
    UserTransaction transaction;

    @Resource
    SessionContext context;

    private String status = "INITIAL";

    @PostConstruct
    public void init(){
        //
    }

    @PreDestroy
    public void destroy(){
        //
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void start() throws RollbackException, SystemException, NotSupportedException {
        //fdsakjgvfs
        transaction.begin();
        ////
        try {
            transaction.commit();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (javax.transaction.RollbackException e) {
            e.printStackTrace();
        }

        transaction.rollback();
    }

    public void apply() {

    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @Override
    public String getEmployeeName(Long id){
        EmpEntity employee =  manager.find(EmpEntity.class, id);
        String name = employee.getEname();
        cache.put(id, name);

        if (false) {
            context.setRollbackOnly();
        }

        return name;
    }

    public void createAndUpdateEmployee(){
        status = "READY";
    }


//    @PrePassivate
//    @Remove
    public void commit(){
        if (!"READY".equalsIgnoreCase(status)) {
            throw new RuntimeException("You can't be here");
        }
    }
}
