import java.util.Scanner;

public class Question7 {

    // Method to check if a student can vote based on age
    public boolean canStudentVote(int age) {
        // Validate if age is a negative number
        if (age < 0) {
            return false;  // Invalid age, cannot vote
        }
        
        // If age is 18 or more, the student can vote
        if (age >= 18) {
            return true;
        } else {
            return false;  // Otherwise, cannot vote
        }
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        
        // Array to hold the ages of 10 students
        int[] studentAges = new int[10];
        
        // Create an instance of StudentVoteChecker to use the method
        Question7 checker = new Question7();
        
        // Loop to take input for each student's age
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
            
            // Check if the student can vote
            boolean canVote = checker.canStudentVote(studentAges[i]);
            
            // Display the result
            if (canVote) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }
        
        // Close the scanner object to avoid resource leak
        scanner.close();
    }
}
