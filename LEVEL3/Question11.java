import java.util.Random;

public class Question11 {

    // Method to generate employee data (salary and years of service)
    public static int[][] generateEmployeeData(int numEmployees) {
        Random random = new Random();
        int[][] employeeData = new int[numEmployees][2]; // 2D array to store salary and years of service
        
        for (int i = 0; i < numEmployees; i++) {
            // Randomly generating salary (5-digit number between 10000 and 99999)
            employeeData[i][0] = 10000 + random.nextInt(90000); 
            // Randomly generating years of service (between 1 and 20 years)
            employeeData[i][1] = 1 + random.nextInt(20);
        }
        return employeeData;
    }

    // Method to calculate bonus, new salary and return the updated 2D array
    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3]; // 3 columns: old salary, new salary, bonus
        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            double bonusPercentage = (yearsOfService > 5) ? 0.05 : 0.02; // 5% for service > 5 years, else 2%
            
            // Calculating the bonus and new salary
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;
            
            updatedData[i][0] = oldSalary;  // old salary
            updatedData[i][1] = newSalary;  // new salary
            updatedData[i][2] = bonus;     // bonus amount
        }
        return updatedData;
    }

    // Method to calculate and display the sum of old salary, new salary, and total bonus
    public static void displayResults(double[][] updatedData) {
        double sumOldSalary = 0, sumNewSalary = 0, totalBonus = 0;
        
        // Displaying the table header
        System.out.println("Employee #\tOld Salary\tNew Salary\tBonus");
        
        // Iterating through the employee data and calculating totals
        for (int i = 0; i < updatedData.length; i++) {
            double oldSalary = updatedData[i][0];
            double newSalary = updatedData[i][1];
            double bonus = updatedData[i][2];
            
            // Printing each employee's data
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\n", i + 1, oldSalary, newSalary, bonus);
            
            // Summing up the totals
            sumOldSalary += oldSalary;
            sumNewSalary += newSalary;
            totalBonus += bonus;
        }
        
        // Displaying the total sums
        System.out.println("\nTotal Sum of Old Salaries: " + sumOldSalary);
        System.out.println("Total Sum of New Salaries: " + sumNewSalary);
        System.out.println("Total Bonus Amount: " + totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10; // We have 10 employees

        // Step 1: Generate random employee data (salary and years of service)
        int[][] employeeData = generateEmployeeData(numEmployees);

        // Step 2: Calculate bonus and new salary for each employee
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);

        // Step 3: Display the results
        displayResults(updatedData);
    }
}
