package lekce_310;

public class SchoolLazy {
    private static SchoolLazy instance = null;

    public static synchronized SchoolLazy getInstance() {
        if (instance == null) instance = new SchoolLazy();
        return instance;
    }

    public String getName() {
        return name;
    }

    private String name;

    private SchoolLazy(){};
}
