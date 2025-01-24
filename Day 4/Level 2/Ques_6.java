
import java.util.Scanner;

public class Ques_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = bmi[i] <= 18.4 ? "Underweight" : bmi[i] <= 24.9 ? "Normal" : bmi[i] <= 39.9 ? "Overweight" : "Obese";
            System.out.println(height[i] + " " + weight[i] + " " + bmi[i] + " " + status[i]);
        }
    }
}
