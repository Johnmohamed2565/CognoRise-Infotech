import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(100) + 1;  
        int attempts = 0;  

        System.out.println("<--Welcome to the Number Guessing Game-->");
        System.out.println("I have chosen a random number in between 1 and 100. Try to guess it:)");
        System.out.println("<--You have multiple attempts-->Good luck:)");

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Too low!");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}
