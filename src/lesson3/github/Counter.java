package lesson3.github;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private AtomicLong sum = new AtomicLong();


    public void incrementBalance() {
        long l = sum.incrementAndGet();

    }

    public AtomicLong getSum() {
        return sum;
    }


}

class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable runnable = () -> {
            for (int i = 0; i < 50000; i++) {
                counter.incrementBalance();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Total: " + counter.getSum());

    }



}
