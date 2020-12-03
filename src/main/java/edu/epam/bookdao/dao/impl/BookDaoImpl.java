package edu.epam.bookdao.dao.impl;

import edu.epam.bookdao.dao.BookDao;
import edu.epam.bookdao.entity.Book;
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
        for (Book book : books) {
            if (book.getBookId() == id){
                result = book;
            }
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
        for (Book book : books) {
            if (book.getTitle().equals(title)){
                result = book;
            }
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
    public void updateTitle(Book book, String title) throws BookDaoException{
        BookStorage bookStorage = BookStorage.getInstance();
        if (!bookStorage.contains(book)){
            throw new BookDaoException("Book doesn't exist " + book);
        }
        int index = bookStorage.indexOf(book);
        bookStorage.get(index).setTitle(title);
    }

    @Override
    public void updateAuthor(Book book,String author) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        if (!bookStorage.contains(book)){
            throw new BookDaoException("Book doesn't exist " + book);
        }
        int index = bookStorage.indexOf(book);
        bookStorage.get(index).setAuthor(author);

    }

    @Override
    public void updatePrice(Book book, BigDecimal price) throws BookDaoException {
        BookStorage bookStorage = BookStorage.getInstance();
        if (!bookStorage.contains(book)){
            throw new BookDaoException("Book doesn't exist " + book);
        }
        int index = bookStorage.indexOf(book);
        bookStorage.get(index).setPrice(price);
    }
}
