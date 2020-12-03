package edu.epam.bookdao.entity;

import java.math.BigDecimal;

public class Book {

    private long bookId;
    private String title;
    private String author;
    private Publisher publisher;
    private int year;
    private int pageNum;
    private BigDecimal price;
    private Cover cover;

    public Book() {}

    public Book(long bookId, String title, String author, Publisher publisher, int year, int pageNum,
                BigDecimal price, Cover cover) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pageNum = pageNum;
        this.price = price;
        this.cover = cover;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("bookId=").append(bookId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", Author=").append(author);
        sb.append(", publisher=").append(publisher);
        sb.append(", year=").append(year);
        sb.append(", pageNum=").append(pageNum);
        sb.append(", price=").append(price);
        sb.append(", cover=").append(cover);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                year == book.year &&
                pageNum == book.pageNum &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publisher == book.publisher &&
                price.equals(book.price) &&
                cover == book.cover;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 23 + (int) bookId;
        hash = hash * 23 + ((title == null) ? 0 : title.hashCode());
        hash = hash * 23 + ((author == null) ? 0 : author.hashCode());
        hash = hash * 23 + ((publisher == null) ? 0 : publisher.hashCode());
        hash = hash * 23 + year;
        hash = hash * 23 + pageNum;
        hash = hash * 23 + ((price == null) ? 0 : price.hashCode());
        hash = hash * 23 + ((cover == null) ? 0 : cover.hashCode());
        return hash;
    }
}
