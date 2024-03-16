package lesson2.synchronizationnjava.tictac;

import java.util.Random;

public class TicTacToeGames {
    public static void main(String[] args) {
        Game game = new Game();
        Random random = new Random();


        Player x = new Player(game, 'X', random);
        Player o = new Player(game, 'O', random);

        Thread X = new Thread(x);
        Thread O = new Thread(o);

        X.start();
        O.start();
    }
}
