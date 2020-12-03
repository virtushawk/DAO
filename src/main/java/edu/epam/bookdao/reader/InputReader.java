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

public class InputReader {
    private final Logger logger = LogManager.getLogger(InputReader.class);
    private static final String BOOK_READ_REGEX = "\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?";

    public List<Book> readFromFile(String path){
        File file = new File(path);
        ArrayList<Book> books = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] data = line.split(BOOK_READ_REGEX);
                long bookId = Long.parseLong(data[0]);
                String title = data[1];
                String authors = data[2];
                Publisher publisher = Publisher.valueOf(data[3]);
                int year = Integer.parseInt(data[4]);
                int pageNum = Integer.parseInt(data[5]);
                BigDecimal price = new BigDecimal(data[6]);
                Cover cover = Cover.valueOf(data[7]);
                Book book = new Book(bookId,title,authors,publisher,year,pageNum,price,cover);
                logger.info("book added to storage {}",book);
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        }
        return books;
    }
}
