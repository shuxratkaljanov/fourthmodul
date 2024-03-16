package lesson2.synchronizationnjava.tictac;

public class Game {
    private char[][] board;
    private boolean gameOver;

    public Game() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        gameOver = false;
    }

    public synchronized boolean isGameOver() {
        return gameOver;
    }

    public void makeMove(int row, int col, char mark) {
        synchronized (Game.class) {

            if (!gameOver && isValidMove(row, col)) {
                board[row][col] = mark;
                pirntBoard();


                if (checkWin(mark)) {
                    System.out.println("Winner " + " '" + mark + "'" + " players ");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("Draw🤝🏼");
                    gameOver = true;
                }
            }
        }

    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(char mark) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == mark && board[row][1] == mark && board[row][2] == mark) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == mark && board[1][col] == mark && board[2][col] == mark) {
                return true;
            }
        }
        if (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
            return true;
        }
        if (board[2][0] == mark && board[1][1] == mark && board[0][2] == mark) {
            return true;
        }
        return false;
    }

    private void pirntBoard() {
        // System.out.println("-----------");
        System.out.println();
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            // System.out.println("-----------");

        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
}
