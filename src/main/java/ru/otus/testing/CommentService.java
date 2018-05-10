package ru.otus.testing;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Stateless
public class CommentService {

    @PersistenceContext(unitName = "jpa")
    private EntityManager em;

    public void create(Comment t) {
        em.merge(t);
    }

    public Collection<Comment> getAll() {
        Query q = em.createNamedQuery("Comment.findAll");
        Collection<Comment> entities = q.getResultList();
        return entities;
    }

}
