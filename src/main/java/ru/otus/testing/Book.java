package ru.otus.testing;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@Entity
@Table(name = "book")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries(
    @NamedQuery(name = Book.FIND_ALL, query = "select b from Book b")
)
public class Book {

    public static final String FIND_ALL = "Book.FindAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long id;

    @NotNull
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    private BigDecimal price;

    @NotNull
    @XmlElement(name = "tax_included")
    private boolean isTaxIncluded;

    /* getter and setter method */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isTaxIncluded() {
        return isTaxIncluded;
    }

    public void setIsTaxIncluded(boolean taxIncluded) {
        isTaxIncluded = taxIncluded;
    }
}
