package lesson3.github;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadSafeCollection {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}

class Producer implements Runnable {
    private final ConcurrentLinkedQueue<Integer> queue;

    public Producer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
            System.out.println("Produced: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private final ConcurrentLinkedQueue<Integer> queue;

    public Consumer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            Integer value = queue.poll();
            if (value != null) {
                System.out.println("Consumed: " + value);
            }
        }
    }
}
