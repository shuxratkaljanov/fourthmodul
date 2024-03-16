package lesson7.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOutputStreamEx {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("shuxrat/shuxa.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
