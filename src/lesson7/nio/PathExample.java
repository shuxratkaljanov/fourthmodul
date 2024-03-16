package lesson7.nio;

import java.nio.file.Path;

public class PathExample {
    public static void main(String[] args) {
        Path path = Path.of("shuxrat/shuxa.txt");
        System.out.println("path.isAbsolute() = " + path.isAbsolute());
        Path absolut = path.toAbsolutePath();
        System.out.println("absolut = " + absolut);
        Path normal = path.toAbsolutePath();
        System.out.println("normal.getParent() = " + normal.getParent());
    }
}
