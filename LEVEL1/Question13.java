import java.util.Scanner;

public class Question13 {

    // Method to calculate various trigonometric functions
    public double[] calculateTrigonometricFunctions(double angle) {
        // Convert the angle from degrees to radians
        double radians = Math.toRadians(angle);

        // Create an array to store the results: sin, cos, tan
        double[] results = new double[3];

        // Calculate sine, cosine, and tangent
        results[0] = Math.sin(radians);  // sin(angle)
        results[1] = Math.cos(radians);  // cos(angle)
        results[2] = Math.tan(radians);  // tan(angle)

        return results;
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking the angle input in degrees
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        // Create an instance of TrigonometricFunctions to calculate the trigonometric values
        Question13 trigFunc = new Question13();

        // Call the method to calculate the trigonometric functions
        double[] results = trigFunc.calculateTrigonometricFunctions(angle);

        // Display the results
        System.out.println("For an angle of " + angle + "°:");
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
}
