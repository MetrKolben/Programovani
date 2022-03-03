package lekce_308;

public class SimpleCounter {

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter sp = new SimpleCounter();
        Thread add = new Thread(() -> sp.addNumber(1_000_000_000L));
        Thread sub = new Thread(() -> sp.subNumber(1_000_000_000L));
//        sp.addNumber(1_000_000_000);
//        sp.subNumber(1_000_000_000);
        add.start();
        sub.start();
        add.join();
        sub.join();
        System.out.println(sp.value);
    }

    private void addNumber(long n) {
//        value += n;
        for (long i = 0; i < n; i++) {
//            Thread.yield();
            inc();
        }
    }

    private void subNumber(long n) {
//        value -= n;
        for (long i = n; i > 0; i--) {
//            Thread.yield();
            dec();
        }
    }

    private long value = 0;
    public long inc() {
        return value++;
    }

    public long dec() {
        return value--;
    }
}
