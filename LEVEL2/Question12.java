import java.util.Random;

public class Question12 {

    // Method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            // Generate random number between 1000 and 9999 (inclusive)
            numbers[i] = 1000 + random.nextInt(9000);
        }

        return numbers;
    }

    // Method to find average, minimum, and maximum of an array
    public static double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];

        // Loop through the array to calculate sum, min, and max
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Calculate average
        double average = sum / numbers.length;

        // Return the results as an array [average, min, max]
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        // Generate an array of 5 random 4-digit numbers
        int[] randomNumbers = generate4DigitRandomArray(5);

        // Find the average, minimum, and maximum values
        double[] results = findAverageMinMax(randomNumbers);

        // Display the generated random numbers
        System.out.println("Generated 4-digit random numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }

        // Display the average, minimum, and maximum values
        System.out.println("\nAverage: " + results[0]);
        System.out.println("Minimum value: " + results[1]);
        System.out.println("Maximum value: " + results[2]);
    }
}
