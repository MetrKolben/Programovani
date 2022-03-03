package lekce_308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deadlock {
    public static void main(String[] args) {
        Deadlock d = new Deadlock();
            Thread apple = new Thread(() -> {
                d.lockFirstLineAndDoSomething();
            });
            Thread banana = new Thread(() -> {
                d.doSomethoing();
            });
            apple.start();
            banana.start();
            try {
                apple.join();
                banana.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private final Object hammer = new Object();
    private final Object pliers = new Object();
    private final Object lock1 = new String("lock1");
    private final Object lock2 = new String("lock2");
    private final List listAndLockSelf = new ArrayList<>();
    private final List<String[]> table = new ArrayList<>();

    public Deadlock() {
        table.add(new String[]{});
    }

    private void lockFirstLineAndDoSomething() {
        System.out.println("lockFirstLineAndDoSomething start " + Thread.currentThread().getId());
        synchronized (table.get(0)) {
            doSomethoing();
        }
        System.out.println("lockFirstLineAndDoSomething stop " + Thread.currentThread().getId());
    }
    private void doSomethoing() {
        System.out.println("doSomething start " + Thread.currentThread().getId());
        synchronized (table) {
            for (String[] line : table) {
                System.out.println("doSomething line start " + Thread.currentThread().getId());
                synchronized (line) {
                    //something
                }
                System.out.println("doSomething line stop " + Thread.currentThread().getId());
            }
            Arrays.asList(new String[]{""});
        }
//        synchronized (listAndLockSelf) {
//            listAndLockSelf.add(hammer);
//        }
        System.out.println("doSomething stop " + Thread.currentThread().getId());
    }
}
