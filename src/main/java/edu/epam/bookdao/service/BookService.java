package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findBookById(Long id);
    Book findBookByTitle(String title);
    void create(Book book);
    void delete(Book book);
    void updateTitle(Book book,String title);
    void updateAuthor(Book book,String author);
    void updatePrice(Book book, BigDecimal price);
    List<Book> sortByTitle();
    List<Book> sortById();
    List<Book> sortByPrice();
}
