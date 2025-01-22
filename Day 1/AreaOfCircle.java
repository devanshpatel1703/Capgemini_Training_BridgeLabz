import java.util.Scanner;

public class AreaOfCircle {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double radius = sc.nextDouble();
    	System.out.println(Math.PI * radius * radius);
	}
}
