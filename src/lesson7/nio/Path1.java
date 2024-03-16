package lesson7.nio;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Path1 {
    public static void main(String[] args) throws IOException {

//        try {
//            java.nio.file.Path path = java.nio.file.Path.of("shuxrat/shuxa.txt");
//            String s = Files.readString(path);
//            System.out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Files.writeString(Path.of("shuxrat/shuxa.txt")," A3A4TOSTOBOYaa", StandardOpenOption.APPEND);
    }
}
