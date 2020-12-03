package edu.epam.bookdao.service.impl;

import edu.epam.bookdao.dao.impl.BookDaoImpl;
import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.exception.BookDaoException;
import edu.epam.bookdao.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);
    private static final BookServiceImpl instance = new BookServiceImpl();
    private BookDaoImpl dao = BookDaoImpl.getInstance();

    private BookServiceImpl() {}

    public static BookServiceImpl getInstance(){
        return instance;
    }

    @Override
    public List<Book> findAll() {
        ArrayList<Book> books = (ArrayList<Book>) dao.findAll();
        logger.info("Found all books {}" ,books);
        return books;
    }

    @Override
    public Book findBookById(Long id) {
        Book book = null;
        try {
            book = dao.findBookById(id);
           logger.info("Found book with id {} , book : {}",id, book);
        } catch (BookDaoException e) {
            logger.error(e);
        }
        return book;
    }

    @Override
    public Book findBookByTitle(String title){
        Book book = null;
        try {
            book = dao.findBookByTitle(title);
            logger.info("Found book with title {} , book : {}",title, book);
        } catch (BookDaoException e) {
            logger.error(e);
        }
        return book;
    }

    @Override
    public void create(Book book) {
        try {
            dao.create(book);
            logger.info("Book added to storage :  {} ",book);
        }
        catch (BookDaoException e){
            logger.error(e);
        }
    }

    @Override
    public void delete(Book book) {
        try {
            dao.delete(book);
            logger.info("Book deleted from storage : {}", book);
        }
        catch (BookDaoException e){
            logger.error(e);
        }
    }

    @Override
    public void updateTitle(Book book, String title) {
        try {
            dao.updateTitle(book,title);
            logger.info("Title updated in book : {} ",title);
        } catch (BookDaoException e) {
            logger.error(e);
        }
    }

    @Override
    public void updateAuthor(Book book, String author) {
        try {
            dao.updateAuthor(book,author);
            logger.info("Author updated in book : {} ",author);
        } catch (BookDaoException e) {
            logger.error(e);
        }
    }

    @Override
    public void updatePrice(Book book, BigDecimal price) {
        try {
            dao.updatePrice(book,price);
            logger.info("Price updated in book : {} ",price);
        } catch (BookDaoException e) {
            logger.error(e);
        }
    }

    @Override
    public List<Book> sortByTitle(){
        ArrayList<Book> books = (ArrayList<Book>) dao.findAll();
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);
        books.sort(comparator);
        logger.info("books were sorted by title : {}", books);
        return books;
    }

    @Override
    public List<Book> sortById(){
        ArrayList<Book> books = (ArrayList<Book>) dao.findAll();
        Comparator<Book> comparator = Comparator.comparing(Book::getBookId);
        books.sort(comparator);
        logger.info("books were sorted by id : {} ", books);
        return books;
    }

    @Override
    public List<Book> sortByPrice(){
        ArrayList<Book> books = (ArrayList<Book>) dao.findAll();
        Comparator<Book> comparator = Comparator.comparing(Book::getPrice);
        books.sort(comparator);
        logger.info("books were sorted by price : {} ", books);
        return books;
    }

}
