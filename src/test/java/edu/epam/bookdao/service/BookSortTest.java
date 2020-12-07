package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.reader.BookReader;
import edu.epam.bookdao.service.impl.BookServiceImpl;
import edu.epam.bookdao.storage.BookStorage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookSortTest {
    public final String FILEPATH = "file/test.txt";
    public ArrayList<Book> expected;

    @BeforeClass
    public void beforeClass(){
        BookReader bookReader = new BookReader();
        BookStorage bookStorage = BookStorage.getInstance();
        List<Book> books = bookReader.readFromFile(FILEPATH);
        expected = new ArrayList<>();
        for (Book book : books) {
            bookStorage.add(book);
            expected.add(book);
        }
    }

    @Test
    public void sortByTitleTest(){
        BookService bookService = BookServiceImpl.getInstance();
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortByTitle();
        expected.sort(Comparator.comparing(Book::getTitle));
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void sortByIdTest(){
        BookService bookService = BookServiceImpl.getInstance();
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortById();
        expected.sort(Comparator.comparing(Book::getBookId));
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void sortByPriceTest(){
        BookService bookService = BookServiceImpl.getInstance();
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortByPrice();
        expected.sort(Comparator.comparing(Book::getPrice));
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void afterClass(){
        expected = null;
    }
}
