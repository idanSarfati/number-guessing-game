public class Game {
    private int targetNumber;
    private int maxTries;
    public int currentTries;

    public Game() {
        this.targetNumber = (int)(Math.random() * 100) + 1;
        this.maxTries = 6;
        this.currentTries = 0;
    }

    public String checkGuess(int guess) {
        currentTries++;
        if (guess == targetNumber) {
            return "Correct!";
        } else if (guess > targetNumber) {
            return "Too high!";
        } else {
            return "Too low!";
        }
    }

    public boolean hasGuessesLeft() {
        return currentTries < maxTries;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public int getTargetNumber() {
        return targetNumber;
    }
}
