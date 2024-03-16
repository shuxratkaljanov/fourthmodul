package lesson7.serdeser;

import java.io.*;
import java.util.List;

public class SerializationExample2 {
    public static void main(String[] args) {
        write();
        read();
    }
@SuppressWarnings("unchecked")
    private static void read() {
        try (
                FileInputStream fileInputStream = new FileInputStream("dota/user.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            List<User> users = (List<User>) objectInputStream.readObject();
            users.forEach(System.out :: println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        List<User> users = List.of(
                new User("ogre", 10, "1"),
                new User("juger", 20, "1"),
                new User("akasha", 30, "1")
        );
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("dota/user.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
