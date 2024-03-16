package lesson2.interrupt;

public class ThreadInterruptException {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                   throw new RuntimeException(e);
                }
            }
        };
        Thread th1 = new Thread(runnable);
        th1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        th1.interrupt();
        System.out.println("End main");
    }
}
