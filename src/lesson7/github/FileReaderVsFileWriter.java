package lesson7.github;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderVsFileWriter {
    public static void main(String[] args) {
//        try (FileWriter fileWriter = new FileWriter("shuxrat/shuxa.txt");) {
//            fileWriter.append("JUGGERNAUT");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try (FileReader fileReader = new FileReader("shuxrat/shuxa.txt")) {
            while (fileReader.ready()) {
                System.out.println((char) fileReader.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
