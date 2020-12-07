package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;
import edu.epam.bookdao.reader.BookReader;
import edu.epam.bookdao.service.impl.BookServiceImpl;
import edu.epam.bookdao.storage.BookStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceTest {
    public final String FILEPATH = "file/test.txt";

    @BeforeClass
    public void beforeClass(){
        BookReader bookReader = new BookReader();
        BookStorage bookStorage = BookStorage.getInstance();
        List<Book> books = bookReader.readFromFile(FILEPATH);
        for (Book book : books) {
            bookStorage.add(book);
        }
    }

    @Test
    public void createTest() {
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = new Book("Test Title","Test author", Publisher.SIMON_AND_SCHUSTER,1851,
                600,new BigDecimal("13.23"), Cover.WIRE_BINDING);
        bookService.create(book);
        boolean actual = bookStorage.contains(book);
        Assert.assertTrue(actual);
    }

    @Test
    public void deleteTest() {
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        Book book = new Book("Test Title","Test author", Publisher.SIMON_AND_SCHUSTER,1851,
                600,new BigDecimal("13.23"), Cover.WIRE_BINDING);
        bookService.delete(book);
        boolean actual = bookStorage.contains(book);
        Assert.assertFalse(actual);
    }

    @Test
    public void updateTitleTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String expected = "New Title";
        Long id = (long) 1;
        bookService.updateTitle(id,expected);
        Book book  = bookStorage.get(id.intValue());
        String actual = book.getTitle();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updateAuthorTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String expected = "New Author";
        Long id = (long) 1;
        bookService.updateAuthor(id,expected);
        Book book = bookStorage.get(id.intValue());
        String actual = book.getAuthor();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updatePriceTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String price = "4.43";
        Long id = (long) 1;
        BigDecimal expected = new BigDecimal(price);
        bookService.updatePrice(id,expected);
        Book book = bookStorage.get(id.intValue());
        BigDecimal actual = book.getPrice();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updatePublisherTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        Publisher expected = Publisher.HARPERCOLLINS;
        Long id = (long) 1;
        bookService.updatePublisher(id,expected);
        Book book = bookStorage.get(id.intValue());
        Publisher actual = book.getPublisher();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updateYearTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        int expected = 1991;
        Long id = (long) 1;
        bookService.updateYear(id,expected);
        Book book = bookStorage.get(id.intValue());
        int actual = book.getYear();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updatePageNumTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        int expected = 500;
        Long id = (long) 1;
        bookService.updatePageNum(id,expected);
        Book book = bookStorage.get(id.intValue());
        int actual = book.getPageNum();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void updateCoverTest(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        Cover expected = Cover.BOARD_BOOK_BINDING;
        Long id = (long) 1;
        bookService.updateCover(id,expected);
        Book book = bookStorage.get(id.intValue());
        Cover actual = book.getCover();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void findBookById(){
        BookStorage bookStorage = BookStorage.getInstance();
        BookService bookService = BookServiceImpl.getInstance();
        Long id = (long) 1;
        Book expected = bookStorage.get(id.intValue());
        Book actual = bookService.findBookById(id);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void findBookByTitle(){
        BookService bookService = BookServiceImpl.getInstance();
        BookStorage bookStorage = BookStorage.getInstance();
        String title = "In Search of Lost Time";
        Book actual = bookService.findBookByTitle(title);
        int id = 0;
        Book expected = bookStorage.get(id);
        Assert.assertEquals(actual,expected);
    }
}
