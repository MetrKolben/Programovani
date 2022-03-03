package lekce_308;

public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    new Thread(this).start();
                }
            }
        }).start();
    }
}
