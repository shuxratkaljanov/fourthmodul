package lesson1;

public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "Thread => 1");
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
        System.out.println("End");
    }
}
