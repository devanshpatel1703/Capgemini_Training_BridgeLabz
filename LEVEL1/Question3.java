import java.util.Scanner;

public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Ensuring at least 2 students for a handshake
        if (numberOfStudents < 2) {
            System.out.println("At least 2 students are needed for a handshake.");
        } else {
            // Using formula to calculate maximum handshakes
            int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

            // Displaying the result
            System.out.println("The maximum number of handshakes possible is: " + maxHandshakes);
        }

        scanner.close();
    }
}
