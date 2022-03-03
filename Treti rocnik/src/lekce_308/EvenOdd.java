package lekce_308;

import java.util.ArrayList;
import java.util.List;

public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        EvenOdd eo = new EvenOdd();
        Thread even = new Thread(() -> eo.fillEven(10_000));
        Thread odd = new Thread(() -> eo.fillOdd(10_000));
//        eo.fillEven(100);
//        eo.fillOdd(100);
        even.start();
        odd.start();
        even.join();
        odd.join();
        System.out.println(eo.list);
    }

    private final List<Integer> list = new ArrayList<>();

    public synchronized void fillEven(int max) {
        for (int i = 2; i <= max; i+=2) {
            synchronized (this) {
                int index = list.size();
                Math.sqrt(Math.random());
                list.add(index, i);
            }
        }
    }

    public synchronized void fillOdd(int max) {
        for (int i = 1; i <= max; i+=2) {
            synchronized (this) {
                int index = list.size();
                Math.sqrt(Math.random());
                list.add(index, i);
            }
        }
    }
}
