package lesson3.aquarium;

import java.util.Random;
import java.util.UUID;

public class Fish extends Thread {
    private final

    Aquarium aquarium;
    private final boolean isMale;
    private int counter;
    private final Random random = new Random();
    public int x;
    public int y;
    private final UUID uuid = UUID.randomUUID();

    public Fish(Aquarium aquarium, boolean isMale, int counter) {
        this.aquarium = aquarium;
        this.isMale = isMale;
        this.counter = counter;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void run() {
        while (counter > 0) {
            counter--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException("Exception");
            }
            if (aquarium.meet(this)) aquarium.displayFishes();
        }

        aquarium.remove(uuid);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "aquarium=" + aquarium +
                ", isMale=" + isMale +
                ", year=" + counter +
                '}';
    }
}
