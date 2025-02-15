import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        String[] strings = new String[n];
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        scanner.close();
        
        String concatenatedString = concatenateStrings(strings);
        System.out.println("Concatenated string: " + concatenatedString);
    }

    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
