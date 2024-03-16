package lesson2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionProblem {
    public static void main(String[] args) throws InterruptedException {
        var wallet = new Wallet();
        Runnable r = () -> {
//            System.out.println(Thread.currentThread().getName() + " started incrementing");
            for (int j = 0; j < 10000; j++) {
                wallet.incrementBalance();
            }
//            System.out.println(Thread.currentThread().getName() + " finished incrementing");
        };
        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("total: " + wallet.getAmount());

    }
}

class Wallet {
    private long amount = 0;
    private Lock lock = new ReentrantLock();

    public void incrementBalance() {
        lock.lock();
        amount++;
        lock.unlock();
    }

    long getAmount() {
        return amount;
    }
}
