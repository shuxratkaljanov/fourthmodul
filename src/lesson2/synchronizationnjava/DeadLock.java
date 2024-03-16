package lesson2.synchronizationnjava;

public class DeadLock {
    public static void main(String[] args) {
        final String str1 = "hello";
        final String str2 = "privet";
        Thread t1 = new Thread() {
            public void run() {
                synchronized (str1) {
                    System.out.println("Thread 1 : locked str1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    synchronized (str2) {
                        System.out.println("Thread 1 : locked str2");
                    }
                }

            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (str2) {
                    System.out.println("Thread 2 : locked str2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                    synchronized (str1) {
                        System.out.println("Thread 2 : locked str1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
