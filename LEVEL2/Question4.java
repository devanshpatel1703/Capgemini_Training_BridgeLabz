public class Question4 {

    // Method to convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // Method to convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // Method to convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // Method to convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    public static void main(String[] args) {
        // Test the utility methods
        double km = 10; // Example value in kilometers
        double miles = 6.2; // Example value in miles
        double meters = 5; // Example value in meters
        double feet = 16.4; // Example value in feet
        
        // Converting kilometers to miles
        double resultKmToMiles = convertKmToMiles(km);
        System.out.println(km + " kilometers is equal to " + resultKmToMiles + " miles.");

        // Converting miles to kilometers
        double resultMilesToKm = convertMilesToKm(miles);
        System.out.println(miles + " miles is equal to " + resultMilesToKm + " kilometers.");

        // Converting meters to feet
        double resultMetersToFeet = convertMetersToFeet(meters);
        System.out.println(meters + " meters is equal to " + resultMetersToFeet + " feet.");

        // Converting feet to meters
        double resultFeetToMeters = convertFeetToMeters(feet);
        System.out.println(feet + " feet is equal to " + resultFeetToMeters + " meters.");
    }
}
