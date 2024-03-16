package lesson2.synchronizationnjava;

public class SynchronizedMultithreading {
    public static void main(String[] args) {
        Sender sender = new Sender();
        SenderWThreads senderWThreads = new SenderWThreads("Hello",sender);
        SenderWThreads senderWThreads2 = new SenderWThreads("Welcome",sender);
        senderWThreads.start();
        senderWThreads2.start();
        try {
            senderWThreads.join();
            senderWThreads2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

    }
}
