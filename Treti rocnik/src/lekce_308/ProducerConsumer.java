package lekce_308;

public class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.get();
        System.out.println("x");
        for (int i = 1; i < 1000; i++) {
            pc.put(i);
            pc.get();
        }
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    pc.put(i);
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    pc.get();
                }
            }
        });
        producer.start();
        consumer.start();
    }
    private final int[] data = new int[100];
    private int put = 0;
    private int get = data.length-1;

    public void put(int value) {
        while (put == get) {
            data[put] = value;
        }
        put = (put+1) % data.length;
    }

    public int get() {
        int newget = (get+1) % data.length;
        while (newget == put){
        }
        return 0;
    }
}
