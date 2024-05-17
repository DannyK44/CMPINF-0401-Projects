/*
 * Created on 2024-03-24
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class Rock extends Choice {

    public Rock() {
        super.setName(GameChoices.ROCK);
    }

    // Using GameChoices to get a nice representation of the paper name
    public String getName() {
        return GameChoices.ROCK;
    }

    // Should return a String of the game round's explanation (e.g., "Rock crushes
    // Lizard")
    public String competeExplanation(Choice otherPlayerChoice) {
        String explanation;
        switch (otherPlayerChoice.getName()) {
            case "Paper \uD83D\uDCC4":
                explanation = "Paper covers Rock";
                break;
            case "Scissors \u2702\uFE0F":
                explanation = "Rock breaks Scissors";
                break;
            case "Lizard \uD83E\uDD8E":
                explanation = "Rock crushes Lizard";
                break;
            case "Spock \uD83D\uDD96️":
                explanation = "Spock vaporizes Rock";
                break;
            case "Rock \uD83E\uDEA8":
                explanation = "Both are Rocks- no winner";
                break;
            default:
                explanation = "Invalid type of choice";
        }
        return explanation;
    }

    /*
     * Compares the choice with the other player's choice
     * - Should return an `int`:
     * - `0`: choice is equal to otherPlayerChoice
     * - `1`: choice wins agains otherPlayerChoice
     * - `-1`: choice looses to otherPlayerChoice
     */
    public int determineWin(Choice otherPlayerChoice) {
        int outcomeId;
        switch (otherPlayerChoice.getName()) {
            case "Scissors \u2702\uFE0F":
            case "Lizard \uD83E\uDD8E":
                outcomeId = 1;
                break;
            case "Paper \uD83D\uDCC4":
            case "Spock \uD83D\uDD96️":
                outcomeId = -1;
                break;
            case "Rock \uD83E\uDEA8":
                outcomeId = 0;
            default:
                outcomeId = 0;
        }
        return outcomeId;
    }
}
