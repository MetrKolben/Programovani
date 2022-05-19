package lekce_310;

public class SpeedTest {
    private final int count;

    public SpeedTest(int count) {
        this.count = count;
    }

    public long test(Runnable run) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            run.run();
        }
        long stop = System.nanoTime();
        return stop-start;
    }
}
