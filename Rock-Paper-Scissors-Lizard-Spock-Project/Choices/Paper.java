public class Paper extends Choice {
    
    public Paper() {
        super.setName(GameChoices.PAPER);
    }

    // Using GameChoices to get a nice representation of the paper name
    public String getName() {
        return GameChoices.PAPER;
    }

    // Returns an exlanation of the outcome of the round of the game
    public String competeExplanation(Choice otherPlayerChoice) {
        String explanation;
        switch (otherPlayerChoice.getName()) {
            case "Rock \uD83E\uDEA8":
                explanation = "Paper covers Rock";
                break;
            case "Scissors \u2702\uFE0F":
                explanation = "Scissors cut Paper";
                break;
            case "Lizard \uD83E\uDD8E":
                explanation = "Lizard eats Paper";
                break;
            case "Spock \uD83D\uDD96️":
                explanation = "Paper disproves Spock";
                break;
            case "Paper \uD83D\uDCC4":
                explanation = "Both are Papers- no winner";
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
            case "Rock \uD83E\uDEA8":
            case "Spock \uD83D\uDD96️":
                outcomeId = 1;
                break;
            case "Scissors \u2702\uFE0F":
            case "Lizard \uD83E\uDD8E":
                outcomeId = -1;
                break;
            case "Paper \uD83D\uDCC4":
                outcomeId = 0;
            default:
                outcomeId = 0;
        }
        return outcomeId;
    }
}
