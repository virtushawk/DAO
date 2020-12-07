package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findBookById(Long id);
    Book findBookByTitle(String title);
    void create(Book book);
    void delete(Book book);
    void updateTitle(Long id,String title);
    void updateAuthor(Long id,String author);
    void updatePrice(Long id, BigDecimal price);
    void updatePublisher(Long id, Publisher publisher);
    void updateYear(Long id, int year);
    void updatePageNum(Long id, int pageNum);
    void updateCover(Long id, Cover cover);
    List<Book> sortByTitle();
    List<Book> sortById();
    List<Book> sortByPrice();
}
