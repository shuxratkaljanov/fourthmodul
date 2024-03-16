package lesson1;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"Thread => 1");
        Thread t2 = new Thread(myRunnable,"Thread => 2");
        t1.start();
        System.out.println("before join");
        t1.join();
        t2.start();
        Thread.sleep(100);
        System.out.println("End");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
