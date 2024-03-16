package lesson5.homework;

import lesson5.MyForkJoinTask;

import java.util.concurrent.RecursiveTask;

public class MyForkJoinT extends RecursiveTask<Double> {
    private double[] nums;
    private int from;
    private int to;
    private int limit;

    public MyForkJoinT(double[] nums, int from, int to, int limit) {
        this.nums = nums;
        this.from = from;
        this.to = to;
        this.limit = limit;
    }

    protected Double compute() {
        //System.out.println(Thread.currentThread().getName() + " => " + Thread.activeCount() + " :: " + from + " : " + to);
        if (to - from <= limit) {
            double sum = 0;
            for (int i = from; i < to; i++) {
                if (nums[i] < 0.3) {
                    sum += nums[i];
                }
                return sum;
            }
        } else {
            try {
                int middle1 = from + (to - from) / 3;
                int middle2 = from + (to - from) * 2 / 3;
                MyForkJoinTask myForkJoinTask1 = new MyForkJoinTask(nums, from, middle1, limit);
                MyForkJoinTask myForkJoinTask2 = new MyForkJoinTask(nums, middle1, middle2, limit);
                MyForkJoinTask myForkJoinTask3 = new MyForkJoinTask(nums, middle2, to, limit);
                invokeAll(myForkJoinTask1, myForkJoinTask2, myForkJoinTask3);
                return myForkJoinTask1.get() + myForkJoinTask2.get() + myForkJoinTask3.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
