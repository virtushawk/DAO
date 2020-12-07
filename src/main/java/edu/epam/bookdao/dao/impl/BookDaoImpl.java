package edu.epam.bookdao.dao.impl;

import edu.epam.bookdao.dao.BookDao;
import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;
import edu.epam.bookdao.exception.BookDaoException;
import edu.epam.bookdao.storage.BookStorage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final BookDaoImpl instance = new BookDaoImpl();

    private BookDaoImpl(){}

    public static BookDaoImpl getInstance(){
        return instance;
    }

    @Override
    public List<Book> findAll() {
        BookStorage bookStorage = BookStorage.getInstance();
        return bookStorage.getBooks();
    }

    @Override
    public Book findBookById(Long id) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        ArrayList<Book> books = (ArrayList<Book>) bookStorage.getBooks();
        Book result = null;
        int i = 0;
        while (i < books.size()) {
            Book book = books.get(i);
            if(book.getBookId() == id){
                result = book;
                break;
            }
            i++;
        }
        if (result == null){
            throw new BookDaoException("There is no book with id " + id);
        }
        return  result;
    }

    @Override
    public Book findBookByTitle(String title) throws BookDaoException{
        BookStorage bookStorage = BookStorage.getInstance();
        ArrayList<Book> books = (ArrayList<Book>) bookStorage.getBooks();
        Book result = null;
        int i = 0;
        while (i < books.size()) {
            Book book = books.get(i);
            if(book.getTitle().equals(title)){
                result = book;
                break;
            }
            i++;
        }
        if (result == null){
            throw new BookDaoException("There is no book with title " + title);
        }
        return  result;
    }

    @Override
    public void delete(Book book) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        if (!bookStorage.contains(book)){
            throw new BookDaoException("Book doesn't exist " + book);
        }
        bookStorage.remove(book);
    }

    @Override
    public void create(Book book) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        if(bookStorage.contains(book)){
            throw  new BookDaoException("Book exists " + book);
        }
        bookStorage.add(book);
    }

    @Override
    public void updateTitle(Long id, String title) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setTitle(title);
    }

    @Override
    public void updateAuthor(Long id, String author) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setAuthor(author);
    }

    @Override
    public void updatePrice(Long id, BigDecimal price) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setPrice(price);
    }

    @Override
    public void updatePublisher(Long id, Publisher publisher) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setPublisher(publisher);
    }

    @Override
    public void updateYear(Long id, int year) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setYear(year);
    }

    @Override
    public void updatePageNum(Long id, int pageNum) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setPageNum(pageNum);
    }

    @Override
    public void updateCover(Long id, Cover cover) {
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = bookStorage.get(id.intValue());
        book.setCover(cover);
    }
}
