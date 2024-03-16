package lesson3;

public class TaskMatrix {
    static int[][] matrix = new int[5000][5000];

    public static void main(String[] args) throws InterruptedException {

        long l = System.currentTimeMillis();

        Thread th1 = new Thread(new MyRunnable(0));
        Thread th2 = new Thread(new MyRunnable(1));
        Thread th3 = new Thread(new MyRunnable(2));
        Thread th4 = new Thread(new MyRunnable(3));
        Thread th5 = new Thread(new MyRunnable(4));
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();

        long l2 = System.currentTimeMillis();


        System.out.println(l2 - l);
        /*for (int i = 0; i < 5000; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }*/
    }

    }

