/*
 * Created on 2024-02-18
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// ! NO NEED TO TOUCH THIS FILE !

public class App {
    public static void main(String[] args) {
        boolean restart;

        do {
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.startGame();
            restart = ticTacToe.playAgain();
        } while (restart);

    }
}
