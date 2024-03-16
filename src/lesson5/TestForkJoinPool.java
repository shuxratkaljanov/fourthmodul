package lesson5;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestForkJoinPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        double[] nums = new double[25000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }
        System.out.println("Started");

        long begin = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask myForkJoinTask = new MyForkJoinTask(nums, 0, nums.length, 2000);
        forkJoinPool.invoke(myForkJoinTask);
        Double res = myForkJoinTask.get();
        long end = System.currentTimeMillis();
        System.out.println("for execution ==> " + (end - begin));
        long begin1 = System.currentTimeMillis();
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0.3)
                sum += nums[i];
        }
        long end1 = System.currentTimeMillis();
        System.out.println("liner execution==> " + (end1 - begin1));
    }
}
