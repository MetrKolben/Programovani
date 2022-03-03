package lekce_308;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PrimeCounter extends Thread{

    private static final AtomicLong counter = new AtomicLong(0);

    private final long from, to;

    public PrimeCounter(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public static void main(String[] args) {
//        for (int i = -1; i < 20; i++) {
//            System.out.println(i + (isPrime(i) ? " je " : " není ") + "prvočíslo"); 664578
//        }
//        System.out.println(countPrimes(0, 10_000_000L));
        List<PrimeCounter> counters = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            counters.add(new PrimeCounter(1_000_000*i, 1_000_000*(i+1)));
        }
        counters.forEach(PrimeCounter::start);
        counters.forEach(PrimeCounter::waitFor);
        System.out.println(counter);
    }

    private void waitFor() {
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrime(long n) {
        if (n<2) return false;
        if (n == 2) return true;
        if (n%2 == 0) return false;
        long max = (long)Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            if (n%i==0) return false;
        }
        return true;
    }

    public static long countPrimes(long from, long to) {
        long count = 0;
        if (from < 3) count++;
        if (from %2 ==0) from++;
        for (long i = from; i <= to; i+=2){
            if (isPrime(i)) count++;
        }
        return count;
    }

    @Override
    public void run() {
        long count = countPrimes(from, to);
        System.out.println(from+"..."+to + ": " + count);
        counter.addAndGet(count);
    }
}
