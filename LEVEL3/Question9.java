import java.util.Scanner;

public class Question9{

    // Method to calculate the Euclidean distance between two points
    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate the equation of the line given two points
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double[] lineEquation = new double[2];
        
        // Calculate the slope (m) of the line
        double slope = (y2 - y1) / (x2 - x1);
        
        // Calculate the y-intercept (b) using the formula b = y1 - m*x1
        double yIntercept = y1 - slope * x1;
        
        // Store the slope and y-intercept in the array
        lineEquation[0] = slope;  // Slope (m)
        lineEquation[1] = yIntercept;  // Y-intercept (b)
        
        return lineEquation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for the coordinates of the two points
        System.out.print("Enter the coordinates of the first point (x1, y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        
        System.out.print("Enter the coordinates of the second point (x2, y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        
        // Calculate the Euclidean distance
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance between the points: " + distance);
        
        // Calculate the equation of the line
        double[] lineEquation = calculateLineEquation(x1, y1, x2, y2);
        double slope = lineEquation[0];
        double yIntercept = lineEquation[1];
        
        // Display the equation of the line
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", slope, yIntercept);
    }
}
