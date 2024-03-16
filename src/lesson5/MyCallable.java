package lesson5;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int from;
    private int to;
    private int array[];

    public MyCallable(int from, int to, int[] array) {
        this.from = from;
        this.to = to;
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += array[i];
        }
        return  sum;
    }
}
