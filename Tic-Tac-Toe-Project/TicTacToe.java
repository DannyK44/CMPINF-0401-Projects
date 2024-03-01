/*
 * Created on 2024-02-18
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        gameBoard = new GameBoard();
        // Reading player names to create the Player objects
        boolean validInput = false;
        while (!validInput) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Enter name for Player 1 (X): ");
                String player1Name = scanner.nextLine();
                player1 = new Player(player1Name, 'X');

                System.out.println("Enter name for Player 2 (O): ");
                String player2Name = scanner.nextLine();
                player2 = new Player(player2Name, 'O');

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid name");
            }
        }
        // player1 starts the game
        currentPlayer = player1;
    }

    // NO NEED TO TOUCH startGame()
    public void startGame() {
        boolean gameEnded = false;
        while (!gameEnded) {
            gameBoard.printBoard();
            placeMove();
            if (gameBoard.checkWin()) {
                gameBoard.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                gameEnded = true;
            } else if (gameBoard.isFull()) {
                gameBoard.printBoard();
                System.out.println("The game ended in a tie!");
                gameEnded = true;
            } else {
                switchPlayers();
            }
        }

    }

    // Asks the player to place a move and checks for its validity
    private void placeMove() {
        boolean validMove = false;

        // Ask the player to place a move
        System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter your move (row and column):");
        // Makes the move on the gameBoard
        while (!validMove) {
            try {
                int rowIndex = scanner.nextInt() - 1;
                int colIndex = scanner.nextInt() - 1;
                // Checking if the move is valid
                if (((rowIndex > GameBoard.SIZE - 1) || (rowIndex < 0)) || (colIndex > GameBoard.SIZE - 1) || (colIndex < 0)) {
                    System.out.println("Please input a number from 1 to 3...");
                } else {
                validMove = gameBoard.makeMove(rowIndex, colIndex, currentPlayer.getSymbol());
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid row and column number.");
                scanner.next();
            }
        }
    }

    // Switch players
    // Sets the player that is not the currentPlayer as the currentPlayer
    private void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if (currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    // Asks the user if they want to play again- restarts the game if they say yes
    public boolean playAgain() {
        boolean validInput = false;
        System.out.println("Do you want to play again? (true or false)");

        while (!validInput) {
            try {
                boolean playAgain = scanner.nextBoolean();
                validInput = true;
                if (playAgain) {
                    return true;
                } else {
                    System.out.println("Thanks for playing!");
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input- do you want to play again?");
                scanner.next();
            }
        }
        return false;
    }
}
