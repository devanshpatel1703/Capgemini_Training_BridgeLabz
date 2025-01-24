
import java.util.Scanner;

public class Ques_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            percentage[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            grade[i] = percentage[i] >= 80 ? 'A' : percentage[i] >= 70 ? 'B' : percentage[i] >= 60 ? 'C' : percentage[i] >= 50 ? 'D' : percentage[i] >= 40 ? 'E' : 'R';
            System.out.println(percentage[i] + " " + grade[i]);
        }
    }
}
