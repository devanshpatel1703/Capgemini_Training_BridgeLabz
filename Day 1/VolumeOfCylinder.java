import java.util.Scanner;

public class VolumeOfCylinder {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	double radius = sc.nextDouble();
    	double height = sc.nextDouble();
    	System.out.println(Math.PI * radius * radius * height);
	}
}

