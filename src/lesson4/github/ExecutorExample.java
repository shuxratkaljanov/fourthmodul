package lesson4.github;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+" ==> "+ " is worked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        executor.execute(runnable);
        System.out.println(Thread.currentThread().getName()+" END ");
        
    }

}
