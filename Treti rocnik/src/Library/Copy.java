package Library;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    private final int registration;
    private final Book book;

    private static List<Copy> copies = new ArrayList<>();

    private Copy(int registration, Book book) {
        this.registration = registration;
        this.book = book;
    }

    public void copy(Book book) {
        int registration = generateRegistration(book.hashCode());
        copies.add(new Copy(registration, book));
    }

    private int generateRegistration(int registration) {
        if (!exists(registration)) {
            return registration;
        } else {
            return generateRegistration((""+registration).hashCode());
        }
    }

    private boolean exists(int registration) {
        for (Copy copy : copies) {
            if (copy.registration == registration) return true;
        }
        return false;
    }

    public int getRegistration() {
        return registration;
    }

    public Book getBook() {
        return book;
    }

    public Copy getCopy(int registration) {
        for (Copy copy : copies) {
            if (copy.registration == registration) return copy;
        }
        return null;
    }
}
