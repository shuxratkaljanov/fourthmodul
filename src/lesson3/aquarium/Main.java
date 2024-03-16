package lesson3.aquarium;

import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();

        int n = random.nextInt(1, 5);
        int m = random.nextInt(1, 5);

        for (int i = 0; i < n; i++) {
            Fish fish = new Fish(aquarium, false, random.nextInt(1, 10));
            aquarium.add(fish);
        }
        for (int i = 0; i < n; i++) {
            Fish fish = new Fish(aquarium, true, random.nextInt(1, 10));
            aquarium.add(fish);
        }
        for (int i = 0; i < (n + m); i++) {
            aquarium.getFish(i).start();
        }

    }
}
