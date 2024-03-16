package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int n = 7;
        int radius = 5;
        int[] values = {1, 3, 2, 4, 6, 9, 1};
        System.out.println("m1(n,radius) = " + m1(n, radius));


    }

    public static int m1(int length, int radius) {
        List<Integer> list = new ArrayList<>();
        int[] values = new int[length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == radius) {
                return radius;
            }
            if (radius - values[i] >= 0) {
                list.add(radius - values[i]);
            }
        }
        Collections.sort(list);
        return list.getFirst();
    }

}

