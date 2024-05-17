public class Lizard extends Choice {
    
    public Lizard() {
        super.setName(GameChoices.LIZARD);
    }

    // Using GameChoices to get a nice representation of the lizard name
    public String getName() {
        return GameChoices.LIZARD;
    }

    // Returns an exlanation of the outcome of the round of the game
    public String competeExplanation(Choice otherPlayerChoice) {
        String explanation;
        switch (otherPlayerChoice.getName()) {
            case "Rock \uD83E\uDEA8":
                explanation = "Rock crushes Lizard";
                break;
            case "Paper \uD83D\uDCC4":
                explanation = "Lizard eats Paper";
                break;
            case "Scissors \u2702\uFE0F":
                explanation = "Scissors decapitate Lizard";
                break;
            case "Spock \uD83D\uDD96️":
                explanation = "Lizard poisons Spock";
                break;
            case "Lizard \uD83E\uDD8E":
                explanation = "Both are Lizards- no winner";
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
            case "Spock \uD83D\uDD96️":
            case "Paper \uD83D\uDCC4":
                outcomeId = 1;
                break;
            case "Rock \uD83E\uDEA8":
            case "Scissors \u2702\uFE0F":
                outcomeId = -1;
                break;
            case "Lizard \uD83E\uDD8E":
                outcomeId = 0;
            default:
                outcomeId = 0;
        }
        return outcomeId;
    }
}
