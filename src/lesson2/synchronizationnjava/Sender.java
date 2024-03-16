package lesson2.synchronizationnjava;

public class Sender {
    public void SenderMsg(String msg) {

        System.out.println("\nSending a Message: " + msg);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + " Sent");
    }
}