import java.util.Scanner;

public class Question1 {
    
    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user inputs
        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest (%): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time period (in years): ");
        double time = scanner.nextDouble();

        // Calculating simple interest
        double interest = calculateSimpleInterest(principal, rate, time);

        // Displaying the result
        System.out.println("The Simple Interest is " + interest + 
                           " for Principal " + principal + 
                           ", Rate of Interest " + rate + 
                           "% and Time " + time + " years.");

        scanner.close();
    }
}
