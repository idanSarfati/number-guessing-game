import java.util.Random;

public class Game {
    protected static final int MAX_NUMBER = 100;
    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_TRIES = 6;
    private int secretNumber;
    private int currentTries;
    private boolean gameWon;
    
    public Game() {
        Random random = new Random();
        this.secretNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
        this.currentTries = 0;
        this.gameWon = false;
    }

    public boolean makeGuess(int guess) {
        currentTries++;
        
        if (guess == secretNumber) {
            gameWon = true;
            return true;
        }
        
        return false;
    }

    public boolean isGameOver() {
        return gameWon || currentTries >= MAX_TRIES;
    }
    
    public boolean isGameWon() {
        return gameWon;
    }

    public boolean hasGuessesLeft() {
        return currentTries < MAX_TRIES;
    }

    public int getCurrentTries() {
        return currentTries;
    }
    
    public int getSecretNumber() {
        return secretNumber;
    }
    
    public int getRemainingTries() {
        return MAX_TRIES - currentTries;
    }
    
    public int getMaxTries() {
        return MAX_TRIES;
    }
    
    public String getHint(int guess) {
        if (guess < secretNumber) {
            return "Too low!";
        } else if (guess > secretNumber) {
            return "Too high!";
        } else {
            return "Correct!";
        }
    }
    
    public int getMissDistance(int guess) {
        return Math.abs(guess - secretNumber);
    }
}
