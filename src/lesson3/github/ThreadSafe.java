package lesson3.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafe {
    public static void main(String[] args) {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        integers.add(1);
        integers.add(2);
        System.out.println(integers);
    }
}
