import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        int lowerBound = 1, upperBound = 100;
        boolean guessedCorrectly = false;
        Random random = new Random();

        while (!guessedCorrectly) {
            int guess = generateGuess(lowerBound, upperBound, random);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");

            String feedback = scanner.nextLine().trim().toLowerCase();

            switch (feedback) {
                case "high":
                    upperBound = guess - 1;
                    break;
                case "low":
                    lowerBound = guess + 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number correctly!");
                    guessedCorrectly = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
        scanner.close();
    }

    // Method to generate the next guess
    public static int generateGuess(int lower, int upper, Random random) {
        return lower + random.nextInt(upper - lower + 1);
    }
}
