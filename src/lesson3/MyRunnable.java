package lesson3;

public class MyRunnable implements Runnable {
    int i ;
    public MyRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = i*1000; j < (i+1)*1000; j++) {
            for (int k = 0; k < 5000; k++) {
                TaskMatrix.matrix[j][k] = (j*5000 + k);
            }
        }
    }
}
