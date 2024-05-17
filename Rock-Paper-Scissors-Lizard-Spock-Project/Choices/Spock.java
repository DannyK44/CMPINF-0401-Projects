public class Spock extends Choice {
    
    public Spock() {
        super.setName(GameChoices.SPOCK);
    }

    // Using GameChoices to get a nice representation of the spock name
    public String getName() {
        return GameChoices.SPOCK;
    }

    // Returns an exlanation of the outcome of the round of the game
    public String competeExplanation(Choice otherPlayerChoice) {
        String explanation;
        switch (otherPlayerChoice.getName()) {
            case "Rock \uD83E\uDEA8":
                explanation = "Spock vaporizes Rock";
                break;
            case "Paper \uD83D\uDCC4":
                explanation = "Paper disproves Spock";
                break;
            case "Lizard \uD83E\uDD8E":
                explanation = "Lizard poisons Spock";
                break;
            case "Scissors \u2702\uFE0F":
                explanation = "Spock smashes Scissors";
                break;
            case "Spock \uD83D\uDD96️":
                explanation = "Both are Spocks- no winner";
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
            case "Scissors \u2702\uFE0F":
            case "Rock \uD83E\uDEA8":
                outcomeId = 1;
                break;
            case "Lizard \uD83E\uDD8E":
            case "Paper \uD83D\uDCC4":
                outcomeId = -1;
                break;
            case "Spock \uD83D\uDD96️":
                outcomeId = 0;
            default:
                outcomeId = 0;
        }
        return outcomeId;
    }
}
