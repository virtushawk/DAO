package edu.epam.bookdao.exception;

public class BookDaoException extends Exception {
    public BookDaoException() {
    }

    public BookDaoException(String message) {
        super(message);
    }

    public BookDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDaoException(Throwable cause) {
        super(cause);
    }

}
