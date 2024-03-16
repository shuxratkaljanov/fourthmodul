package lesson5.homework;

import lesson5.MyForkJoinTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        double[] nums = new double[250_000_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }

        System.out.println("started");

//        System.out.println(Thread.currentThread().getName() + " => " + Thread.activeCount() + " :: " + from + " : " + to);


        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        MyForkJoinTask myForkJoinTask = new MyForkJoinTask(nums, 0, nums.length, 200_000);
        forkJoinPool.invoke(myForkJoinTask);

        Double res = myForkJoinTask.get();// block
        long end = System.currentTimeMillis();

        System.out.println("for execution :: " + (end-begin));


        begin = System.currentTimeMillis();
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0.3)
                sum += nums[i];
        }
        end = System.currentTimeMillis();

        System.out.println("liner execution :: " + (end-begin));

    }
}
