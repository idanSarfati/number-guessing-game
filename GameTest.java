import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    @Test
    public void testSecretNumberInRange() {
        Game game = new Game();
        int secretNumber = game.getSecretNumber();
        assertTrue("Secret number should be between 1 and 100", 
                  secretNumber >= 1 && secretNumber <= 100);
    }

    @Test
    public void testCorrectGuessWinsGame() {
        Game game = new Game();
        int secretNumber = game.getSecretNumber();
        
        boolean result = game.makeGuess(secretNumber);
        
        assertTrue("Guessing the correct number should return true", result);
        assertTrue("Game should be won after correct guess", game.isGameWon());
    }

    @Test
    public void testGameOverAfterMaxTries() {
        Game game = new Game();
        int secretNumber = game.getSecretNumber();
        int incorrectGuess = secretNumber > 50 ? 1 : 100; // Ensure wrong guess
        
        for (int i = 0; i < game.getMaxTries(); i++) {
            game.makeGuess(incorrectGuess);
        }
        
        assertTrue("Game should be over after max tries", game.isGameOver());
        assertFalse("Game should not be won after incorrect guesses", game.isGameWon());
    }
}
