import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filename = "employees.csv"; 
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();
            System.out.println(header);
            System.out.println("-".repeat(60));

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 5) {
                    System.out.println("Invalid row (Missing fields): " + line);
                    continue;
                }

                Matcher emailMatcher = emailPattern.matcher(data[3]);
                Matcher phoneMatcher = phonePattern.matcher(data[4]);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email: " + data[3] + " in row: " + line);
                }

                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number: " + data[4] + " in row: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
