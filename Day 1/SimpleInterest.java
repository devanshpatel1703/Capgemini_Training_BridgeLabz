import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double principal = sc.nextDouble();
    	double rate = sc.nextDouble();
    	double time = sc.nextDouble();
    	System.out.println((principal * rate * time) / 100);
	}
}

