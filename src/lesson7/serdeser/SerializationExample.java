package lesson7.serdeser;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("dota/user.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            User user = (User) objectInputStream.readObject();
            System.out.println(System.identityHashCode(user));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void write() {
        User user = new User("Shuxa", 21, "WO-DOTER");
        System.out.println(System.identityHashCode(user));
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("dota/user.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
