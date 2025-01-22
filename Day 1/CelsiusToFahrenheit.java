import java.util.Scanner;

public class CelsiusToFahrenheit {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double celsius = sc.nextDouble();
    	System.out.println((celsius * 9 / 5) + 32);
	}
}
