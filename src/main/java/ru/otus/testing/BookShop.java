package ru.otus.testing;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;

@Stateless
public class BookShop {

    @PersistenceContext(name = "jpa")
    EntityManager em;

    @Inject
    Logger log;

    public List<Book> findAllBook() {
        log.info("Find All Books");
        return this.em.createNamedQuery(Book.FIND_ALL).getResultList();
    }

    public Book findBookById(Long id) {
        log.info("Find Book by ID");
        return this.em.find(Book.class, id);
    }

    public void addBookStock(Book book) {
        log.info("Create New Book");
        this.em.persist(book);
    }

    public void removeBookStock(Book book) {
        log.info("Remove New Book");
        this.em.remove(book);
    }

    public JsonObject getBookOrder(Long id, URI self) {
        log.info("Check New Order from Specific Book");
        Book book = findBookById(id);
        return Json.createObjectBuilder()
                .add("isbn", book.getIsbn())
                .add("title", book.getTitle())
                .add("_links", Json.createObjectBuilder()
                        .add("rel", "self")
                        .add("href", self.toString())
                )
                .build();
    }
}
