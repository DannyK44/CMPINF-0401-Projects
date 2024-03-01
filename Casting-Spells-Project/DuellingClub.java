/*
 * Created on Wed Jan 31 2024
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class DuellingClub {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Dueling Club!\n");

        Dueler dueler1 = new Dueler("Harry Potter");
        Dueler dueler2 = new Dueler("Hermione Granger");

        Duel duel = new Duel(dueler1, dueler2);
        duel.startDuel(dueler1, dueler2);

        Dueler winner = duel.duel(dueler1, dueler2);
        duel.declareWinner(winner);
    }
}
