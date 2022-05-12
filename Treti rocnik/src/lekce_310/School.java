package lekce_310;

public class School {
    private static final School instance = new School();

    public static School getInstance() {
        return instance;
    }

    private String name;

    private School() {
    }
}
