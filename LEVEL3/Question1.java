import java.util.Random;

public class Question1 {

    // Method to generate an array of random heights for 11 players between 150 cm and 250 cm
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        Random random = new Random();

        // Generate random heights between 150 and 250 cm for each player
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + random.nextInt(101); // Generates a number between 150 and 250
        }

        return heights;
    }

    // Method to find the sum of all heights in the array
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // Method to find the mean height
    public static double findMeanHeight(int[] heights) {
        int sum = findSum(heights);
        return sum / (double) heights.length;
    }

    // Method to find the shortest height
    public static int findShortestHeight(int[] heights) {
        int minHeight = heights[0];
        for (int height : heights) {
            if (height < minHeight) {
                minHeight = height;
            }
        }
        return minHeight;
    }

    // Method to find the tallest height
    public static int findTallestHeight(int[] heights) {
        int maxHeight = heights[0];
        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        // Generate random heights for 11 players
        int[] heights = generateHeights(11);

        // Find the shortest, tallest, and mean heights
        int shortest = findShortestHeight(heights);
        int tallest = findTallestHeight(heights);
        double meanHeight = findMeanHeight(heights);

        // Display the heights of all players
        System.out.println("Heights of players (in cm):");
        for (int height : heights) {
            System.out.print(height + " ");
        }

        // Display the shortest, tallest, and mean heights
        System.out.println("\n\nShortest height: " + shortest + " cm");
        System.out.println("Tallest height: " + tallest + " cm");
        System.out.println("Mean height: " + meanHeight + " cm");
    }
}
