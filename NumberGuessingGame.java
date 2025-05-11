import java.util.Scanner;


public class NumberGuessingGame {
    public static void main(String[] args) {
        // Intro
        System.out.println("========================================");
        System.out.println("🎉 Welcome to the Guess the Number Game! 🎉");
        System.out.println("========================================");
        System.out.println("Instructions:");
        System.out.println("- I have selected a random number between 1 and 100.");
        System.out.println("- Your goal is to guess the number.");
        System.out.println("- After each guess, I will tell you if it's too high or too low.");
        System.out.println("- You only have 6 guesses until the game will over!");
        System.out.println();
        System.out.println("Let's begin! Good luck! 🍀");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        //Generate a number
        int number = (int)(Math.random() * 100) + 1;

        //Player guess loop
        for(int i=0; i<6; i++){
            System.out.println("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("❌ That's not a valid number. Please enter a number between 1 and 100.");
                scanner.next(); // Clear the invalid input
                i--; // So the invalid input doesn't count as a try
                continue;
            }
int guess = scanner.nextInt();

            System.out.println("You guessed: " + guess);
            if(guess == number) {
                System.out.println("Correct! You did it! And it only took " + (i+1) + " guesses!");
                System.out.println("The game is over now, you are invited to come and play again!");
                break;
            }
            else {
                System.out.println("Oops, that is wrong, you have " + (5-i) + " more tries");
                if(i==5) {
                    System.out.println("You could not find the number and you are out of guesses...");
                    System.out.println("The number was " + number);
                    System.out.println("You had just " + Math.abs(number - guess) + " numbers far away");
                    System.out.println("Game Over!");
                    break;
                }
                if(guess > number){
                    System.out.println("I can only tell you that your current guess was too high");
                }
                else {
                    System.out.println("I can only tell you that your current guess was too low");
                }
            }
        }

        // Option to play again
        System.out.print("\nDo you want to play again? (yes/no): ");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            main(args); // Restart the game
        } else {
            System.out.println("Thanks for playing! Goodbye! 👋");
        }

        scanner.close();

    }
}