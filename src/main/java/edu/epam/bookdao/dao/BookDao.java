package edu.epam.bookdao.dao;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.exception.BookDaoException;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book findBookById(Long id) throws BookDaoException;
    Book findBookByTitle(String title) throws BookDaoException;
    void delete(Book book) throws BookDaoException;
    void create(Book book) throws BookDaoException;
    void updateTitle(Book book,String title) throws BookDaoException;
    void updateAuthor(Book book,String author) throws BookDaoException;
    void updatePrice(Book book, BigDecimal price) throws  BookDaoException;
}
