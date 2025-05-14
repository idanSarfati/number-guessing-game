import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage(int minNumber, int maxNumber, int maxTries) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + minNumber + " and " + maxNumber);
        System.out.println("You have " + maxTries + " tries to guess it.");
    }

    public int getGuess() {
        System.out.println("Enter your guess:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
            System.out.println("Enter your guess:");
        }
        return scanner.nextInt();
    }

    public void displayHint(String hint) {
        System.out.println(hint);
    }

    public void displayWinMessage() {
        System.out.println("Congratulations! You guessed the number!");
    }

    public void displayRemainingTries(int remainingTries) {
        System.out.println("You have " + remainingTries + " guesses left.");
    }

    public void displayMissDistance(int lastGuess, int secretNumber) {
        int distance = Math.abs(lastGuess - secretNumber);
        System.out.println("You missed by " + distance + "! The number was " + secretNumber + ".");
        
        if (distance <= 5) {
            System.out.println("So close!");
        } else if (distance <= 20) {
            System.out.println("Not too far off!");
        } else {
            System.out.println("That was quite far!");
        }
    }

    public boolean askPlayAgain() {
        while (true) {
            System.out.println("Would you like to play again? (y/n)");
            String response = scanner.next();
            
            if (response.equalsIgnoreCase("y")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                displayGoodbyeMessage();
                return false;
            } else {
                System.out.println("Invalid response. Please enter 'y' for yes or 'n' for no.");
            }
        }
    }

    private void displayGoodbyeMessage() {
        System.out.println("Thank you for playing! Goodbye! 👋");
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
