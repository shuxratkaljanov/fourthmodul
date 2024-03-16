package lesson1;

public class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(Thread.currentThread().getName() + " => " + i);
        }
    }
}
class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyTask();
        MyThread th1 = new MyThread();
        Thread th2 = new Thread(new MyTask());
        th1.start();
        th2.start();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + " => " + "End of Main");

    }
}
