package Library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String name;

    private final String author;

    private final int year;
    private final String publisher;
    private final String ISBN;
    private static List<Book> books = new ArrayList<>();

    Book(String name, String author, int year, String publisher, String ISBN) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }

    public static void add(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public static List<Book> getBooks() {
        return books;
    }
}
