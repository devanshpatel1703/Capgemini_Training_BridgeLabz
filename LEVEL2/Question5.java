public class Question5 {

    // Method to convert yards to feet
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    // Method to convert feet to yards
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    // Method to convert meters to inches
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    // Method to convert inches to meters
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    // Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        // Test the utility methods
        double yards = 5;   // Example value in yards
        double feet = 15;   // Example value in feet
        double meters = 3;  // Example value in meters
        double inches = 40; // Example value in inches
        
        // Converting yards to feet
        double resultYardsToFeet = convertYardsToFeet(yards);
        System.out.println(yards + " yards is equal to " + resultYardsToFeet + " feet.");

        // Converting feet to yards
        double resultFeetToYards = convertFeetToYards(feet);
        System.out.println(feet + " feet is equal to " + resultFeetToYards + " yards.");

        // Converting meters to inches
        double resultMetersToInches = convertMetersToInches(meters);
        System.out.println(meters + " meters is equal to " + resultMetersToInches + " inches.");

        // Converting inches to meters
        double resultInchesToMeters = convertInchesToMeters(inches);
        System.out.println(inches + " inches is equal to " + resultInchesToMeters + " meters.");

        // Converting inches to centimeters
        double resultInchesToCentimeters = convertInchesToCentimeters(inches);
        System.out.println(inches + " inches is equal to " + resultInchesToCentimeters + " centimeters.");
    }
}
