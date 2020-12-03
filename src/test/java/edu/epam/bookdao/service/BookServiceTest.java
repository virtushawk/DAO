package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;
import edu.epam.bookdao.reader.InputReader;
import edu.epam.bookdao.service.impl.BookServiceImpl;
import edu.epam.bookdao.storage.BookStorage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceTest {
    public Book book;
    public String FILEPATH = "file/test.txt";

    @BeforeClass
    public void beforeClass(){
        InputReader inputReader = new InputReader();
        BookStorage bookStorage = BookStorage.getInstance();
        List<Book> books = inputReader.readFromFile(FILEPATH);
        for (Book book : books) {
            bookStorage.add(book);
        }
        book = new Book(11,"Test Title","Test author", Publisher.SIMON_AND_SCHUSTER,1851,
                600,new BigDecimal("13.23"), Cover.WIRE_BINDING);
    }

    @Test
    public void createTest() {
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        bookService.create(book);
        boolean actual = bookStorage.contains(book);
        Assert.assertTrue(actual);
    }

    @Test
    public void deleteTest() {
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        bookService.delete(book);
        boolean actual = bookStorage.contains(book);
        Assert.assertFalse(actual);
    }

    @Test
    public void updateTitleTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        bookStorage.add(book);
        String expected = "New Title";
        bookService.updateTitle(book,expected);
        int index = bookStorage.indexOf(book);
        Book temp  = bookStorage.get(index);
        String actual = temp.getTitle();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updateAuthorTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String expected = "New Author";
        bookService.updateAuthor(book,expected);
        int index = bookStorage.indexOf(book);
        Book temp = bookStorage.get(index);
        String actual = temp.getAuthor();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updatePriceTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String price = "4.43";
        BigDecimal expected = new BigDecimal(price);
        bookService.updatePrice(book,expected);
        int index = bookStorage.indexOf(book);
        Book temp = bookStorage.get(index);
        BigDecimal actual = temp.getPrice();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void findBookById(){
        BookStorage bookStorage = BookStorage.getInstance();
        BookService bookService = BookServiceImpl.getInstance();
        bookStorage.add(book);
        long id = 11;
        Book actual = bookService.findBookById(id);
        Assert.assertEquals(actual,book);
    }

    @Test
    public void findBookByTitle(){
        BookService bookService = BookServiceImpl.getInstance();
        String title = "Test Title";
        Book actual = bookService.findBookByTitle(title);
        Assert.assertEquals(actual,book);
    }

    @AfterClass
    public void afterClass(){
        book = null;
    }

}
