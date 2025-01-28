import java.util.Scanner;

public class Question8 {

    // Method to find the youngest of the three friends
    public static String findYoungest(String[] friends, int[] ages) {
        int youngestAge = ages[0];
        String youngestFriend = friends[0];

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestFriend = friends[i];
            }
        }
        return youngestFriend;
    }

    // Method to find the tallest of the three friends
    public static String findTallest(String[] friends, double[] heights) {
        double tallestHeight = heights[0];
        String tallestFriend = friends[0];

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestFriend = friends[i];
            }
        }
        return tallestFriend;
    }

    public static void main(String[] args) {
        // Create a scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Names of the three friends
        String[] friends = {"Amar", "Akbar", "Anthony"};
        
        // Arrays to store the ages and heights of the three friends
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Taking input for the ages and heights of the three friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            
            System.out.print("Enter the height of " + friends[i] + " in meters: ");
            heights[i] = scanner.nextDouble();
        }

        // Find and display the youngest friend
        String youngestFriend = findYoungest(friends, ages);
        System.out.println("The youngest friend is: " + youngestFriend);

        // Find and display the tallest friend
        String tallestFriend = findTallest(friends, heights);
        System.out.println("The tallest friend is: " + tallestFriend);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
