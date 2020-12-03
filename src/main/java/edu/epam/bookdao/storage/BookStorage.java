package edu.epam.bookdao.storage;

import edu.epam.bookdao.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookStorage {
    private static final BookStorage instance = new BookStorage();
    private ArrayList<Book> books = new ArrayList<>();

    private BookStorage() {}

    public static BookStorage getInstance(){
        return instance;
    }

    public List<Book> getBooks(){
        return new ArrayList<>(books);
    }

    public void add(Book book){
        books.add(book);
    }

    public void remove(Book book){
        books.remove(book);
    }

    public boolean contains(Book book){
        return books.contains(book);
    }

    public Book get(int index){
        return books.get(index);
    }

    public int indexOf(Book book){
        return books.indexOf(book);
    }

}
