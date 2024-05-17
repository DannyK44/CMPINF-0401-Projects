public class Scissors extends Choice {

    public Scissors() {
        super.setName(GameChoices.SCISSORS);
    }

    // Using GameChoices to get a nice representation of the scissors name
    public String getName() {
        return GameChoices.SCISSORS;
    }

    // Returns an exlanation of the outcome of the round of the game
    public String competeExplanation(Choice otherPlayerChoice) {
        String explanation;
        switch (otherPlayerChoice.getName()) {
            case "Rock \uD83E\uDEA8":
                explanation = "Rock breaks Scissors";
                break;
            case "Paper \uD83D\uDCC4":
                explanation = "Scissors cut Paper";
                break;
            case "Lizard \uD83E\uDD8E":
                explanation = "Scissors decapitate Lizard";
                break;
            case "Spock \uD83D\uDD96️":
                explanation = "Spock smashes Scissors";
                break;
            case "Scissors \u2702\uFE0F":
                explanation = "Both are Scissors- no winner";
                break;
            default:
                explanation = "Invalid type of choice";
        }
        return explanation;
    }

    // Compares the choice to the other player's choice and determines the winner
    public int determineWin(Choice otherPlayerChoice) {
        int outcomeId;
        switch (otherPlayerChoice.getName()) {
            case "Paper \uD83D\uDCC4":
            case "Lizard \uD83E\uDD8E":
                outcomeId = 1;
                break;
            case "Spock \uD83D\uDD96️":
            case "Rock \uD83E\uDEA8":
                outcomeId = -1;
                break;
            case "Scissors \u2702\uFE0F":
                outcomeId = 0;
            default:
                outcomeId = 0;
        }
        return outcomeId;
    }
    
}
