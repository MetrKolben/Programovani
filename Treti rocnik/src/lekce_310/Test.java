package lekce_310;

public class Test {
    public static void main(String[] args) {
        SpeedTest test = new SpeedTest(100);
        long j = test.test(()-> {
            for (int i = 0; i < 100_000_000L; ++i) {

            }
        });
        long k = test.test(()-> {
            for (int i = 0; i < 100_000_000L; i++) {

            }
        });
        System.out.println(j);
        System.out.println(k);
        System.out.println(j>k);
    }
}
