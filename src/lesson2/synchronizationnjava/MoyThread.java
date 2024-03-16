package lesson2.synchronizationnjava;

public class MoyThread extends Thread {
    TableStatic table;

    MoyThread(TableStatic t) {
        this.table = t;
    }

    @Override
    public void run() {
        table.printTable(5);
    }
}
