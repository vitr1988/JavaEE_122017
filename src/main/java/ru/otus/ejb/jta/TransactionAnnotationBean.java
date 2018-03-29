package ru.otus.ejb.jta;

import javax.ejb.Stateful;
import javax.transaction.Transactional;

@Stateful
public class TransactionAnnotationBean {

    @Transactional(Transactional.TxType.REQUIRED)
    public void required() {
        System.out.println(getClass().getName() + "Transactional.TxType.REQUIRED");
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void requiresNew() {
        System.out.println(getClass().getName() + "Transactional.TxType.REQUIRES_NEW");
    }

    @Transactional(Transactional.TxType.MANDATORY)
    public void mandatory() {
        System.out.println(getClass().getName() + "Transactional.TxType.MANDATORY");
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public void supports() {
        System.out.println(getClass().getName() + "Transactional.TxType.SUPPORTS");
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void notSupported() {
        System.out.println(getClass().getName() + "Transactional.TxType.NOT_SUPPORTED");
    }

    @Transactional(Transactional.TxType.NEVER)
    public void never() {
        System.out.println(getClass().getName() + "Transactional.TxType.NEVER");
    }
}
