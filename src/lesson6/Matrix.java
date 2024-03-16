package lesson6;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Matrix {
    static Random random = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

//        int n = random.nextInt(3, 6);
//        int m = random.nextInt(3, 6);
        int n = 3;
        int m = 3;
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[m][n];

        fillMatrix(matrixA);
        fillMatrix(matrixB);

        matrix(matrixA);
        System.out.println();

        matrix(matrixB);
        System.out.println();

        int[][] matrixC = new int[n][m];
        Future<Integer>[] futures = new Future[n];
        for (int i = 0; i < n; i++) {
            final int iFinal = i;
            Callable<Integer> callable = () -> {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += matrixA[iFinal][k] * matrixB[k][j];
                    }
                    matrixC[iFinal][j] = sum;
                    sum = 0;
                }
                return 0;
            };
            //Future<Integer> future = executor.submit(callable);

            futures[i] = executor.submit(callable);

        }

        for (int i = 0; i < n; i++) {
            futures[i].get();
        }


        matrix(matrixC);
    }

    public static void matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void fillMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(0, 9);
            }
        }
    }
}
