package lesson4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {
    public static void main(String[] args) throws InterruptedException {
        // m1();
        //m2();
        //m3();
        //m4();
        m5();
    }

    private static void m1() { // single
        //Executor
        //ExecutorService
        //ScheduledExecutorService

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " is worked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };
        executor.execute(runnable);
        executor.execute(runnable);
        System.out.println(Thread.currentThread().getName() + " End");
    }

    private static void m2() throws InterruptedException {
        System.out.println(Thread.activeCount());
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            final int iFinal = i + 1;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + "-> " + iFinal + " task " + Thread.activeCount());
            };
            executor.execute(runnable);
        }
        Thread.sleep(1000);
        System.out.println(Thread.activeCount());

    }

    private static void m3() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println(Thread.activeCount());
        for (int i = 0; i < 200; i++) {
            final int iFinal = i + 1;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + " :: " + iFinal + " task :: " + Thread.activeCount());
                throw new RuntimeException(Thread.currentThread().getName() + " dada dediyu o'ldi");
            };
            executor.execute(runnable);
        }
        Thread.sleep(5000);
        System.out.println(Thread.activeCount());
        System.out.println("End");
    }

    private static void m4() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread() + " " + new Date());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println("---" + Thread.currentThread().getName() + " finished " + new Date());
        };
        //executor.schedule(runnable, 3, TimeUnit.SECONDS);
        //executor.scheduleAtFixedRate(runnable,2,3,TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(runnable, 2, 1, TimeUnit.SECONDS);
        System.out.println("END");
    }

    private static void m5() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            final int iFinal = i + 1;
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName() + "==>" + iFinal + " task " + Thread.activeCount());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            executor.execute(runnable);
        }
        System.out.println(Thread.currentThread().getName() + " END ");
        // executor.shutdown();
//        executor.shutdownNow();
//        Thread.sleep(1000);
//        System.out.println(Thread.activeCount());
        if(!executor.awaitTermination(5,TimeUnit.SECONDS)){
            executor.shutdownNow();
        }else {
            System.out.println(Thread.activeCount());
        }
    }
 }
