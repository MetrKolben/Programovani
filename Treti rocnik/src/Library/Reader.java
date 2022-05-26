package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {
    private final int registration;

    private final String name;

    private static List<Reader> readers = new ArrayList<>();

    private Reader(int registration, String name) {
        this.registration = registration;
        this.name = name;
    }

    public void createReader(String name) {
        int registration = name.hashCode();
        if (!containsReader(registration)) {
            readers.add(new Reader(registration, name));
        }
    }

    private boolean containsReader(int registration) {
        for (Reader r : readers) {
            if (r.registration == registration) return true;
        }
        return false;
    }

    public static Reader getReader(int registration) {
        for (Reader r : readers) {
            if (r.registration == registration) return r;
        }
        return null;
    }

    public int getRegistration() {
        return registration;
    }

    public String getName() {
        return name;
    }
}
