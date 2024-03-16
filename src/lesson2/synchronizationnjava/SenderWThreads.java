package lesson2.synchronizationnjava;

public class SenderWThreads extends Thread {
    private String msg;
    Sender sender;

    public SenderWThreads(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    @Override
    public void run() {
        synchronized (sender){
            sender.SenderMsg(msg);
        }
    }
}
