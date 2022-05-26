package Library;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Borrowing {
    private final int readerReg, bookReg, id;

    private final Date start;
    private static List<Borrowing> borrowings = new ArrayList<>();

    public static void borrow(int readerReg, int bookReg) {
        borrowings.add(new Borrowing(readerReg,
                bookReg,
                (readerReg+""+bookReg).hashCode(),
                Calendar.getInstance().getTime()));
    }

    public Borrowing(int readerReg, int bookReg, int id, Date start) {
        this.readerReg = readerReg;
        this.bookReg = bookReg;
        this.id = id;
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public int getReaderReg() {
        return readerReg;
    }

    public int getBookReg() {
        return bookReg;
    }

    public Date getStart() {
        return start;
    }

    public Borrowing getBorrowing(int id) {
        for (Borrowing b : borrowings) {
            if (b.id == id) return b;
        }
        return null;
    }
}
