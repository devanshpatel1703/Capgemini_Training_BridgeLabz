import java.util.Scanner;

public class Question2 {
    
    // Method to calculate the maximum number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Validating input (minimum 2 students needed for a handshake)
        if (numberOfStudents < 2) {
            System.out.println("At least 2 students are needed for a handshake.");
        } else {
            // Calculating the number of handshakes
            int maxHandshakes = calculateHandshakes(numberOfStudents);

            // Displaying the result
            System.out.println("The maximum number of handshakes possible is: " + maxHandshakes);
        }

        scanner.close();
    }
}
