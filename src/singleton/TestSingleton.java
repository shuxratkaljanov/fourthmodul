package singleton;

import java.io.*;

public class TestSingleton {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("single/sing.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {

            Singleton singleton = (Singleton) objectInputStream.readObject();
//            System.out.println(singleton);
            System.out.println(System.identityHashCode(singleton));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        Singleton instance = Singleton.getInstance();
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("single/sing.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            System.out.println(System.identityHashCode(instance));
            objectOutputStream.writeObject(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
