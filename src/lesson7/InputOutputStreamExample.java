package lesson7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class InputOutputStreamExample {
    public static void main(String[] args) {
        //output();
        input();
    }

    private static void input() {
        try {
            FileInputStream is = new FileInputStream("shuxrat/shuxa.txt");
//            int read = is.read();
//            System.out.println((char) read);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
            StringBuilder str = new StringBuilder();
            int k = 0;
            while (k!=-1){
                k = is.read();
                System.out.println((char) k);
                str.append((char) k);
            }
            System.out.print(str);
    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        private static void output() {
//        try (FileOutputStream os = new FileOutputStream("shuxrat/shuxa.txt")) {
//            byte[] bytes = "Salom bu Java G38 a qashqirlari".getBytes();
//            System.out.println(Arrays.toString(bytes));
//            os.write(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       // os.write(100);
//
//        FileOutputStream os = null;
//        try {
//            os = new FileOutputStream("shuxrat/shuxa.txt", true);
//
//            byte[] bytes = "Salom bu Java G38 а qashqirlari".getBytes();
//            System.out.println(Arrays.toString(bytes));
//            os.write(bytes);
//
////            os.write(100);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

        }
    }


