package lesson6;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MatrixVersion2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int m = 2000;
        int n = 2000;
        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[n][m];
        fillMatrix(matrix1);
        fillMatrix(matrix2);
        ExecutorService executor = Executors.newFixedThreadPool(16);
        int[][] res = new int[m][m];
        ArrayList<Future<Boolean>> futures = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            MyCallable myCallable = new MyCallable(matrix1, matrix2, res, i);
            Future<Boolean> submit = executor.submit(myCallable);
            futures.add(submit);
        }
        System.out.println("Start");
        for (Future<Boolean> future : futures) {
            future.get();
        }
        System.out.println("end");
        executor.shutdown();
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }
}

class MyCallable implements Callable<Boolean> {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] res;
    private int row;

    public MyCallable(int[][] matrixA, int[][] matrixB, int[][] res, int row) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.res = res;
        this.row = row;
    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < res[row].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixA[i].length; j++) {
                sum += matrixA[i][j] * matrixB[j][i];
            }
            res[row][i] = sum;
        }
        return true;
    }
}
