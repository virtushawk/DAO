package edu.epam.bookdao.service;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.reader.InputReader;
import edu.epam.bookdao.service.impl.BookServiceImpl;
import edu.epam.bookdao.storage.BookStorage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BookSortTest {
    public final String FILEPATH = "file/test.txt";

    @BeforeClass
    public void beforeClass(){
        InputReader inputReader = new InputReader();
        BookStorage bookStorage = BookStorage.getInstance();
        List<Book> books = inputReader.readFromFile(FILEPATH);
        for (Book book : books) {
            bookStorage.add(book);
        }
    }

    @Test
    public void sortByTitleTest(){
        String PATH = "file/sortByTitle.txt";
        BookService bookService = BookServiceImpl.getInstance();
        InputReader inputReader = new InputReader();
        ArrayList<Book> expected = (ArrayList<Book>) inputReader.readFromFile(PATH);
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortByTitle();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void sortByIdTest(){
        String PATH = "file/sortById.txt";
        BookService bookService = BookServiceImpl.getInstance();
        InputReader inputReader = new InputReader();
        ArrayList<Book> expected = (ArrayList<Book>) inputReader.readFromFile(PATH);
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortById();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void sortByPriceTest(){
        String PATH = "file/sortByPrice.txt";
        BookService bookService = BookServiceImpl.getInstance();
        InputReader inputReader = new InputReader();
        ArrayList<Book> expected = (ArrayList<Book>) inputReader.readFromFile(PATH);
        ArrayList<Book> actual = (ArrayList<Book>) bookService.sortByPrice();
        Assert.assertEquals(actual,expected);
    }

    @AfterClass
    public void afterClass(){

    }
}
