import java.util.Scanner;

public class AverageOfThreeNumbers {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double num1 = sc.nextDouble();
    	double num2 = sc.nextDouble();
    	double num3 = sc.nextDouble();
    	System.out.println((num1 + num2 + num3) / 3);
	}
}
