package ru.otus.testing;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BookShopTest {
    private static final Long ID = 1L;

    BookShop bookShop; // class under test

    @Before
    public void setUp() {
        this.bookShop = new BookShop(); // Tested class, so don't mock it.
        this.bookShop.em = mock(EntityManager.class);
        this.bookShop.log = mock(Logger.class);
    }

    @Test
    public void shouldGetListOfBooks() {
        List<Book> books = new ArrayList<>();

        Query mockedQuery = mock(Query.class);
        when(mockedQuery.getResultList()).thenReturn(books);
        when(mockedQuery.setParameter(
                Matchers.anyString(), Matchers.anyObject())
        ).thenReturn(mockedQuery);
        when(this.bookShop.em.createNamedQuery(Book.FIND_ALL))
                .thenReturn(mockedQuery);

        books = this.bookShop.findAllBook();

        assertThat(books, is(not(nullValue())));
    }

    @Test
    public void shouldGetAllBooks() {
        List<Book> books = new ArrayList<>();

        Book book = mock(Book.class);
        when(book.getId()).thenReturn(8L);

        books.add(book);

        Query mockedQuery = mock(Query.class);
        when(mockedQuery.getResultList()).thenReturn(books);
        when(mockedQuery.setParameter(
                Matchers.anyString(), Matchers.anyObject())
        ).thenReturn(mockedQuery);
        when(this.bookShop.em.createNamedQuery(Book.FIND_ALL))
                .thenReturn(mockedQuery);

        books = this.bookShop.findAllBook();

        assertThat(books.size(), is(1));
    }

    @Test
    public void shouldGetBookById() {
        Book expected = new Book();

        when(this.bookShop.em.find(Matchers.anyObject(), Matchers.anyLong()))
                .thenReturn(expected);

        Book actual = this.bookShop.findBookById(ID);

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void shouldRemoveBook() {
        Book book = new Book();
        /**
         * doNothing(), doAnswer(), doThrow() used to test void method, the
         * format: doNothing().when(bean).method_name();
         */
        doNothing().when(this.bookShop.em).remove(Matchers.anyObject());

        this.bookShop.removeBookStock(book);

        verify(this.bookShop.em).remove(book);
    }

    @Test
    public void shouldSaveBook() {
        Book book = new Book();

        doNothing().when(this.bookShop.em).persist(Matchers.anyObject());

        this.bookShop.addBookStock(book);

        verify(this.bookShop.em).persist(book);
    }

}
