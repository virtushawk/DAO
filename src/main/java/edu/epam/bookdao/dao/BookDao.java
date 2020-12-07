package edu.epam.bookdao.dao;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;
import edu.epam.bookdao.exception.BookDaoException;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book findBookById(Long id) throws BookDaoException;
    Book findBookByTitle(String title) throws BookDaoException;
    void delete(Book book) throws BookDaoException;
    void create(Book book) throws BookDaoException;
    void updateTitle(Long id, String title);
    void updateAuthor(Long id, String author);
    void updatePrice(Long id, BigDecimal price);
    void updatePublisher(Long id, Publisher publisher);
    void updateYear(Long id, int year);
    void updatePageNum(Long id, int pageNum);
    void updateCover(Long id, Cover cover);
}
