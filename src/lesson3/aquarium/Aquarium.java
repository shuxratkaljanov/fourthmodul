package lesson3.aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Aquarium {
    private final List<Fish> fishList = new ArrayList<>();
    private Random random = new Random();

    public void add(Fish fish) {
        fishList.add(fish);
    }

    public synchronized boolean remove(UUID uuid) {
        Fish fish = findByUUID(uuid);
        if (fish == null) return false;
        fishList.remove(findByUUID(uuid));
        return true;
    }

    public Fish getFish(int i) {
        //if (i > fishList.size()) throw new RuntimeException("Unaqa indeksdagi element yo'q !");
        return fishList.get(i);
    }

    private Fish findByUUID(UUID uuid) {
        for (Fish fish : fishList) {
            if (fish.getUuid() == uuid) return fish;
        }
        return null;
    }

    public synchronized boolean meet(Fish fish) {
//        if (lastFish != null) {
//            if (lastFish.isMale() != fish.isMale()) {
//                Fish childFish = new Fish(this, random.nextBoolean(), random.nextInt(10));
//                add(childFish);
//                childFish.start();
//                lastFish = fish;
//                return true;
//            }
//        }
//        lastFish = fish;
//        return false;
        for (Fish fish1 : fishList) {
            if (fish1.x == fish.x && fish1.y == fish.y && fish1.isMale() != fish.isMale()) {
                Fish childFish = new Fish(this, random.nextBoolean(), random.nextInt(1, 10));
                add(childFish);
                return true;
            }
        }
        return false;
    }

    public synchronized void displayFishes() {
        int i = 1;
        for (Fish fish : fishList) {
            if (fish.getCounter() == 0) continue;

            System.out.println((i++) + " " + fish);
        }
        System.out.println("<----------------------------------------->");
        System.out.println();
    }

    @Override
    public String toString() {
        return "Aquarium =>";
    }
}
