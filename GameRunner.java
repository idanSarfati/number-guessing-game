
public class GameRunner {

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        boolean playAgain = true;

        try {
            while (playAgain) {
                Game game = new Game(); // Create a new game for each round
                ui.displayWelcomeMessage(Game.MIN_NUMBER, Game.MAX_NUMBER, Game.MAX_TRIES);
                int lastGuess = -1;

                while (game.hasGuessesLeft() && !game.isGameWon()) {
                    lastGuess = ui.getGuess();
                    boolean isCorrect = game.makeGuess(lastGuess);
                    String hint = game.getHint(lastGuess);

                    ui.displayHint(hint);

                    if (isCorrect) {
                        ui.displayWinMessage();
                        break;
                    }

                    ui.displayRemainingTries(game.getRemainingTries());
                }

                if (!game.hasGuessesLeft() && !game.isGameWon()) {
                    ui.displayMissDistance(lastGuess, game.getSecretNumber());
                }

                playAgain = ui.askPlayAgain();
            }
        } finally {
            ui.close();
        }

        }
}
