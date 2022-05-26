package Library;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {
    private String name;
    private String author;
    private int year;
    private String publisher;
    private String isbn;


    public BookBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public BookBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public BookBuilder setISBN(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Book createBook() {
        Book b = new Book(name, author, year, publisher, isbn);
        Book.add(b);
        return b;
    }
}