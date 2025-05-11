import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game(); // Create a new game for each round

            System.out.println("========================================");
            System.out.println("🎉 Welcome to the Number Guessing Game! 🎉");
            System.out.println("========================================");
            System.out.println("Guess the number between 1 and 100. You have 6 tries!");
            System.out.println("========================================");

            while (game.hasGuessesLeft()) {
                System.out.println("Enter your guess:");
                if (scanner.hasNextInt()) {
                    int guess = scanner.nextInt();
                    String result = game.checkGuess(guess);
                    System.out.println(result);

                    if (result.equals("Correct!")) {
                        System.out.println("Congratulations! You guessed the number!");
                        break;
                    }

                    System.out.println("You have " + (game.getMaxTries() - game.currentTries) + " guesses left.");
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                }
            }

            if (!game.hasGuessesLeft()) {
                System.out.println("Game over! The number was " + game.getTargetNumber());
            }

            // Ask the player if they want to play again
            boolean validResponse = false;
            while (!validResponse) {
                System.out.println("Would you like to play again? (y/n)");
                String response = scanner.next();

                if (response.equalsIgnoreCase("y")) {
                    validResponse = true;
                } else if (response.equalsIgnoreCase("n")) {
                    validResponse = true;
                    playAgain = false; // Set playAgain to false to end the game
                    System.out.println("Thank you for playing! Goodbye! 👋");
                } else {
                    System.out.println("Invalid response. Please enter 'y' for yes or 'n' for no.");
                }
            }
        }

        scanner.close();
    }
}
