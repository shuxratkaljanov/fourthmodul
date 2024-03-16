package lesson7.io;

import java.io.*;
import java.util.List;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {
        // reader();
        writer();
    }

    private static void writer() {

        try (
                FileWriter fileWriter = new FileWriter("shuxrat/shuxa.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            bufferedWriter.newLine();
            bufferedWriter.append("SHUXA4TOSTOBOY");
            bufferedWriter.newLine();
            bufferedWriter.append("Shuxa-WO-DOTER");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void reader() {

        try (
                FileReader fileReader = new FileReader("shuxrat/shuxa.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            List<String> collect = bufferedReader.lines().toList();
            for (String s : collect) {
                System.out.println(s);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
