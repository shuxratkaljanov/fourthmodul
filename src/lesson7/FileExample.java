package lesson7;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
//        File file = new File("shuxrat/shuxa.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.exists());
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        boolean delete = file.delete();
//        System.out.println(delete);
        File file = new File("shuxrat/shuxa.txt");
        System.out.println(file.getParent());
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.exists());
    }
}
