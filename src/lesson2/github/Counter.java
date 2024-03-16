package lesson2.github;

public class Counter {
    private int sum = 0;
    public synchronized void counter(){
        setSum(getSum()+1);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
