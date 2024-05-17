/*
 * Created on 2024-03-24
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

// Choice functions as the Base class for all the choices
// There is no default Choice!- meaning that the Choice class is abstract

public abstract class Choice {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    // Constructor
    public Choice() {
        
    }

    // Returns a string with the choices name- must be implemented in all of the subclasses
    public abstract String getName();

    // Compares the choice to the other player's choice and determines the winner
    // Must be present in all of the subclasses
    public abstract int determineWin(Choice otherPlayerChoice);

    // Returns an exlanation of the outcome of the round of the game
    // Must be present in all of the subclasses
    public abstract String competeExplanation(Choice otherPlayerChoice);

    // NO NEED TO TOUCH compete()
    public int compete(Choice otherPlayerChoice) {
        System.out.println("Outcome: " + competeExplanation(otherPlayerChoice));
        return determineWin(otherPlayerChoice);
    }
}
