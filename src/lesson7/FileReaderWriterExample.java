package lesson7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {
    public static void main(String[] args) {
        //output();
        input();
    }
    private static void output(){
        File file = new File("shuxrat/shuxa.txt");
        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.append("hello");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private static void input(){
        File file = new File("shuxrat/shuxa.txt");
        try(FileReader fileReader = new FileReader(file)) {
            while (fileReader.ready()){
                System.out.print((char) fileReader.read());
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
