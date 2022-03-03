package lekce_308;

import java.util.concurrent.atomic.AtomicLong;

public class Counter extends Thread{
    private static AtomicLong counter = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Counter c2 = new Counter();
        System.out.println("starting");
        c.start();
        c2.start();
        System.out.println("waiting");
        c.join();
        c2.join();
        System.out.println(counter);
    }

    @Override
    public void run() {
        System.out.println("running");
        for (int i = 0; i < 1_000_000_000; i++) {
            counter.incrementAndGet();
        }
        System.out.println("finished");
    }
}
