package lesson2.synchronizationnjava;

public class MoyThread2 extends Thread {
    TableStatic table;

    MoyThread2(TableStatic t) {
        this.table = t;
    }

    @Override
    public void run() {
        table.printTable(100);
    }
}

class TestSynchronization1 {
    public static void main(String[] args) {
        TableStatic table = new TableStatic();
        MoyThread t1 = new MoyThread(table);
        MoyThread2 t2 = new MoyThread2(table);
        t1.start();
        t2.start();

    }
}
