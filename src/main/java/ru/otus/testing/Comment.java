package ru.otus.testing;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comm")
@NamedQueries({@NamedQuery(name = "Comment.findAll", query = "select e from Comment e")})
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
