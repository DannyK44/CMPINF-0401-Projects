/*
 * Created on 2024-02-18
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class GameBoard {
    private char[][] board;

    // 'final' means that SIZE is a constant and cannot be changed after
    // initialization
    // Java convention: Constants in Java are written in all upper-case letters
    // The size indicates the gameboard size (3x3)
    public static final int SIZE = 3;

    // Default constructor for GameBoard object
    // Empty tiles on the board are marked using '-'
    public GameBoard() {
        char[][] gameBoard = new char[SIZE][SIZE];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = '-';
            }
        }
        this.board = gameBoard;
    }

    // Places a symbol in a given spot if it is not already occupied
    public boolean makeMove(int row, int col, char symbol) {

        if (board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        } else {
            return false;
        }
    }

    // Checks if a player has placed three symbols in a row, column, or diagonal
    // If yes, that player has won
    public boolean checkWin() {
        // Checking rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != '-') {
                if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
                    return true;
                }
            }
        }
        // Checking columns
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] != '-') {
                if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
                    return true;
                }
            }
        }
        // Checking diagonals
        char firstSquare = board[0][0];
        char secondSquare = board[1][1];
        char thirdSquare = board[2][2];
        if (firstSquare != '-') {
            if ((firstSquare == secondSquare) && (secondSquare == thirdSquare)) {
                return true;
            }
        }

        firstSquare = board[2][0];
        thirdSquare = board[0][2];
        if (firstSquare != '-') {
            if ((firstSquare == secondSquare) && (secondSquare == thirdSquare)) {
                return true;
            }
        }

        return false;
    }

    // Checks if the gameboard is full but no player won
    public boolean isFull() {
        int emptySquares = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    emptySquares++;
                }
            }
        }
        if ((emptySquares == 0) && !checkWin()) {
            return true;
        } else {
            return false;
        }
    }

    //Prints out nicely formatted game board
    public void printBoard() {

        System.out.println();
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("|---|---|---|");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n");
    }
}
