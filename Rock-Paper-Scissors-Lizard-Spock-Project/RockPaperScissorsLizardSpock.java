/*
 * Created on 2024-03-24
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

    private Player player;
    private Player computer;

    // Keeping track of the number of wins required to win the game- as well as how many wins each player has
    private final int minWins = 2;
    private static int playerWins = 0;
    private static int computerWins = 0;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    // Constructor for RockPaperScissorsLizardSpock objects
    // Initializes the two player objects, taking user input for the first one
    protected RockPaperScissorsLizardSpock() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Player 1, please enter your name:");
                player = new Player(scanner.nextLine());
                System.out.println();
                computer = new Player("Computer");
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid name");
            }
        }
    }

    // Playing one round of the game
    public void playRound() {
        Choice playerChoice;
        Choice computerChoice;
        int roundOutcome;
        boolean validInput = false;

        System.out.printf(player.getName() + ", please enter %s, %s, %s, %s, or %s: %n", GameChoices.ROCK,
                GameChoices.PAPER, GameChoices.SCISSORS, GameChoices.LIZARD, GameChoices.SPOCK);

        while (!validInput) {
            try {
                // Reading user input for the player to choose their Choice
                playerChoice = getChoice(scanner.nextLine());
                // Generating a random Choice for the computer
                computerChoice = getRandomChoice();

                System.out.println(computer.getName() + " selects " + computerChoice.getName());
                roundOutcome = playerChoice.compete(computerChoice);

                // Determining the winner of the singular round using roundOutcome and
                // incrementing the number of wins for the winner
                if (roundOutcome == 1) {
                    System.out.println("Round result: " + player.getName() + " wins this round");
                    playerWins++;
                } else if (roundOutcome == -1) {
                    System.out.println("Round result: " + computer.getName() + " wins this round");
                    computerWins++;
                } else {
                    System.out.println("This round results in a tie- no winner");
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice...please select again");
                scanner.next();
            }
        }
        System.out.println();
    }

    // Converting the player's input into a Choice object to be used
    private Choice getChoice(String choice) {
        choice = choice.toLowerCase();
        // Checking the passed string and returning a Choice object (i.e., Rock, Paper,
        // Scissors, Lizard, or Spock)
        // Choosing rock as the default choice
        Choice chosenMove;
        switch (choice) {
            case "rock":
                chosenMove = new Rock();
                break;
            case "paper":
                chosenMove = new Paper();
                break;
            case "scissors":
                chosenMove = new Scissors();
                break;
            case "spock":
                chosenMove = new Spock();
                break;
            case "lizard":
                chosenMove = new Lizard();
                break;
            default:
                chosenMove = new Rock();
                System.out.println("Invalid input- Rock chosen as default");
                break;
        }
        return chosenMove;
    }

    // Generating a random choice from the computer to play against the user
    private Choice getRandomChoice() {
        // Returning a Choice object based upon a random number (i.e., Rock, Paper,
        // Scissors, Lizard, or Spock)
        // Choosing rock as the default case
        int choiceNumber = random.nextInt(5) + 1;
        Choice chosenMove;

        switch (choiceNumber) {
            case 1:
                chosenMove = new Rock();
                break;
            case 2:
                chosenMove = new Paper();
                break;
            case 3:
                chosenMove = new Scissors();
                break;
            case 4:
                chosenMove = new Spock();
                break;
            case 5:
                chosenMove = new Lizard();
                break;
            default:
                chosenMove = new Rock();
                System.out.println("Rock chosen as default case");
                break;
        }
        return chosenMove;
    }

    // Main game loop and checking to see who wins the game
    public void startGame() {
        // Continues the game if neither player has reached the number of victories required to win (minWins)
        while ((playerWins < minWins) && (computerWins < minWins)) {
            playRound();
        }

        // Printing out the winner of the game
        if (playerWins == minWins) {
            System.out.println("\n" + player.getName() + " wins the game!!");
        } else if (computerWins == minWins) {
            System.out.println(computer.getName() + " wins the game!!");
        } else {
            System.out.println("No winner");
        }

        // Printing out the final score of the game
        System.out.println("Final score: " + player.getName() + ": " + playerWins + 
                        " vs. " + computer.getName() + ": " + computerWins);

    }

    // NO NEED TO TOUCH main()
    public static void main(String[] args) {
        RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock();
        game.startGame();
        game.scanner.close();
    }
}
