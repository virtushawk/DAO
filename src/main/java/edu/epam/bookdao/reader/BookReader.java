package edu.epam.bookdao.reader;

import edu.epam.bookdao.entity.Book;
import edu.epam.bookdao.entity.Cover;
import edu.epam.bookdao.entity.Publisher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReader {
    private final Logger logger = LogManager.getLogger(BookReader.class);

    public List<Book> readFromFile(String path){
        File file = new File(path);
        ArrayList<Book> books = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                Book book = parseBook(line);
                books.add(book);
                logger.info("book added to storage {}",book);
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        return books;
    }

    public Book parseBook(String line){
        String [] data = line.split(",");
        String title = data[0];
        String authors = data[1];
        Publisher publisher = Publisher.valueOf(data[2]);
        int year = Integer.parseInt(data[3]);
        int pageNum = Integer.parseInt(data[4]);
        BigDecimal price = new BigDecimal(data[5]);
        Cover cover = Cover.valueOf(data[6]);
        return new Book(title,authors,publisher,year,pageNum,price,cover);
    }
}
