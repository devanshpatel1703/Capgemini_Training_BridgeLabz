public class Question6 {

    // Method to convert Fahrenheit to Celsius
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }

    // Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }

    // Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }

    // Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }

    // Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }

    // Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }

    public static void main(String[] args) {
        // Test the utility methods with example values
        double fahrenheit = 98.6;  // Example value in Fahrenheit
        double celsius = 37;      // Example value in Celsius
        double pounds = 150;      // Example value in pounds
        double kilograms = 68;    // Example value in kilograms
        double gallons = 5;       // Example value in gallons
        double liters = 20;       // Example value in liters
        
        // Converting Fahrenheit to Celsius
        double resultFahrenheitToCelsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F is equal to " + resultFahrenheitToCelsius + "°C.");

        // Converting Celsius to Fahrenheit
        double resultCelsiusToFahrenheit = convertCelsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C is equal to " + resultCelsiusToFahrenheit + "°F.");

        // Converting pounds to kilograms
        double resultPoundsToKilograms = convertPoundsToKilograms(pounds);
        System.out.println(pounds + " pounds is equal to " + resultPoundsToKilograms + " kilograms.");

        // Converting kilograms to pounds
        double resultKilogramsToPounds = convertKilogramsToPounds(kilograms);
        System.out.println(kilograms + " kilograms is equal to " + resultKilogramsToPounds + " pounds.");

        // Converting gallons to liters
        double resultGallonsToLiters = convertGallonsToLiters(gallons);
        System.out.println(gallons + " gallons is equal to " + resultGallonsToLiters + " liters.");

        // Converting liters to gallons
        double resultLitersToGallons = convertLitersToGallons(liters);
        System.out.println(liters + " liters is equal to " + resultLitersToGallons + " gallons.");
    }
}
