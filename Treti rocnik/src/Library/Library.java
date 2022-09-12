package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final String LIBRARY_NAME = "NTK";

    public static Library getInstance() {
        if (instance == null) instance = new Library(LIBRARY_NAME);
        return instance;
    }
    private static Library instance = null;

    private Library(String name) {
        this.name = name;
    }

    public final String name;


}
