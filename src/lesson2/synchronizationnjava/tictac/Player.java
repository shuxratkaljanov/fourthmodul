package lesson2.synchronizationnjava.tictac;

import lesson2.synchronizationnjava.tictac.Game;

import java.util.Random;


public class Player implements Runnable {
    private Game game;
    private char mark;
    private Random random;

    public Player(Game game, char mark, Random random) {
        this.game = game;
        this.mark = mark;
        this.random = random;
    }


    @Override
    public void run() {
        while (!game.isGameOver()) {
            synchronized (game) {
                int row = getRandomNumber();
                int col = getRandomNumber();
                game.makeMove(row, col, mark);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public int getRandomNumber() {
        return random.nextInt(3);
    }
}
