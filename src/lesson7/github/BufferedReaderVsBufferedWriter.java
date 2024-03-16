package lesson7.github;

import java.io.*;

public class BufferedReaderVsBufferedWriter {
    public static void main(String[] args) {
        writer();
        reader();
    }

    private static void writer() {
        try (
                FileWriter fileWriter = new FileWriter("shuxrat/shuxa.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            bufferedWriter.newLine();
            bufferedWriter.append(" VS SLARK");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void reader() {
        try (
                FileReader fileReader = new FileReader("shuxrat/shuxa.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while (bufferedReader.ready()){
                System.out.println((char) bufferedReader.read());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
