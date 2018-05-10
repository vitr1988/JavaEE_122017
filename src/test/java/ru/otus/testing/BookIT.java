package ru.otus.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class BookIT {

    EntityManager em;
    EntityTransaction tx;

    @Before
    public void setUp() {
        this.em = Persistence.createEntityManagerFactory("integration-test")
                .createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @After
    public void tearDown() {
        this.em.clear();
        this.em.close();
    }

    @Test
    public void validateORMMapping() {
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("1000"));
        book.setTitle("Война и мир");
        book.setIsTaxIncluded(false);

        this.tx.begin();
        this.em.merge(book);
        this.tx.commit();
    }
}
