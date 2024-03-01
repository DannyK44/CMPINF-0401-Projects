/*
 * Created on Wed Jan 31 2024
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Duel {
    Random random = new Random(System.currentTimeMillis());

    private Dueler dueler1;

    private Dueler dueler2;

    // A Duel should involve two duelers
    Duel(Dueler dueler1, Dueler dueler2) {
        // TODO
        this.dueler1 = dueler1;
        this.dueler2 = dueler2;

    }

    public void startDuel(Dueler dueler1, Dueler dueler2) {
        System.out.println("Duel starts between " + dueler1.getName() + " and " + dueler2.getName() + ":");

    }

    public Dueler duel(Dueler duler1, Dueler dueler2) {
        // Where the casting spells takes place
        Scanner scanner = new Scanner(System.in);

        // Initializing duel variables and prompting the user for input
        int numberOfRounds;
        int completedRounds;
        System.out.println("How many rounds do you want the battle to be (0-3)?");
        int roundNumber = 1;
        boolean validInput = false;

        // Accepting input from the user and reprompting if the input was not right
        while (!validInput) {
            try {
                numberOfRounds = scanner.nextInt();
                if (numberOfRounds > 3) {  // Alerting the user that their input for numberOfRounds was too high!
                    System.out.println("Input was too high ---> 3 round duel assumed");
                }
                
                completedRounds = 0;
                scanner.close();

                // iterating the rounds of the duel
                while ((completedRounds < numberOfRounds) && completedRounds < 3) {
                    // First attack of the round
                    System.out.println("\nRound " + roundNumber + ":");
                    dueler1.castSpell(dueler2);
                    validInput = true;

                    if (dueler2.getUnconscious() == true) {
                        System.out.println(
                                dueler2.getName() + " has been knocked unconscious..." + dueler1.getName() + " wins!!");
                        return dueler1;
                    }

                    // Second attack of the round
                    dueler2.castSpell(dueler1);
                    validInput = true;

                    if (dueler1.getUnconscious() == true) {
                        System.out.println(
                                dueler1.getName() + " has been knocked unconscious..." + dueler2.getName() + " wins!!");
                        return dueler2;
                    }
                    roundNumber++;
                    completedRounds++;
                }
                // Determing the winner of the duel
                if (dueler1.getImpact() > dueler2.getImpact()) {
                    /// add something validInput
                    return dueler2;
                } else if (dueler1.getImpact() < dueler2.getImpact()) {
                    return dueler1;
                } else {
                    return null;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input- please input number of rounds (0-3)");
                scanner.next();
                
            }
        }
        return null;
    }

    // Printing out the results of the duel
    public void declareWinner(Dueler winner) {

        if (winner == null) {
            return;
        } else {
            System.out.println("\nImpact on " + dueler1.getName() + ": " + dueler1.getImpact());
            System.out.println("Impact on " + dueler2.getName() + ": " + dueler2.getImpact() + "\n");

            System.out.println(winner.getName() + " has won the duel!");
        }
    }
}
