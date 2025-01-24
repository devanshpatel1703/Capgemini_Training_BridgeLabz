
import java.util.Scanner;

public class Ques_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] data = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextDouble();
            data[i][1] = sc.nextDouble();
            data[i][2] = data[i][1] / (data[i][0] * data[i][0]);
            status[i] = data[i][2] <= 18.4 ? "Underweight" : data[i][2] <= 24.9 ? "Normal" : data[i][2] <= 39.9 ? "Overweight" : "Obese";
            System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + status[i]);
        }
    }
}
