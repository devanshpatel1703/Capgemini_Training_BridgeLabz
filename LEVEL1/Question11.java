import java.util.Scanner;

public class Question11 {

    // Method to calculate the wind chill temperature
    public double calculateWindChill(double temperature, double windSpeed) {
        // Apply the wind chill formula
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Taking temperature and wind speed as input
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();

        // Create an instance of WindChillCalculator to calculate wind chill
        Question11 calculator = new Question11();

        // Call the method to calculate the wind chill temperature
        double windChill = calculator.calculateWindChill(temperature, windSpeed);

        // Display the result
        System.out.println("The wind chill temperature is: " + windChill + "°F");
    }
}
