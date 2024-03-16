package lesson7;

import java.io.*;

public class ExampleFiles {
    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("shuxrat/shuxa.txt");
            outputStream.write("Hello world!".getBytes());
            outputStream.close();
            // Reading from a file using InputStream
            InputStream inputStream = new FileInputStream("shuxrat/shuxa.txt");
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.println((char) data);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
