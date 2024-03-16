package lesson5;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new int[1000];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = k++;
        }
        System.out.println(Arrays.toString(array));
        MyCallable myCallable1 = new MyCallable(0, 500, array);
        MyCallable myCallable2 = new MyCallable(500, 1000, array);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> future = executor.submit(myCallable1);
        Future<Integer> future1 = executor.submit(myCallable2);

        TimeUnit.SECONDS.sleep(3);
        
        System.out.println("1=>" + future.get());
        System.out.println("2=>" + future1.get());
    }
}
