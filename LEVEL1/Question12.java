import java.util.Scanner;

public class Question12 {

    // Method to calculate trigonometric functions
    public static void calculateTrigonometricFunctions(double angleInDegrees) {
        // Convert the angle to radians
        double angleInRadians = Math.toRadians(angleInDegrees);

        // Calculate the trigonometric functions
        double sinValue = Math.sin(angleInRadians);
        double cosValue = Math.cos(angleInRadians);
        double tanValue = Math.tan(angleInRadians);
        double secValue = 1 / cosValue;  // Secant is 1 / cosine
        double cosecValue = 1 / sinValue;  // Cosecant is 1 / sine
        double cotValue = 1 / tanValue;  // Cotangent is 1 / tangent

        // Print the results
        System.out.println("Trigonometric values for " + angleInDegrees + "°:");
        System.out.println("Sin: " + sinValue);
        System.out.println("Cos: " + cosValue);
        System.out.println("Tan: " + tanValue);
        System.out.println("Sec: " + secValue);
        System.out.println("Cosec: " + cosecValue);
        System.out.println("Cot: " + cotValue);
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for the angle in degrees
        System.out.print("Enter the angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        // Call the method to calculate and display trigonometric functions
        calculateTrigonometricFunctions(angleInDegrees);
    }
}
