
import java.util.Scanner;

public class Ques_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            salary[i] = sc.nextDouble();
            years[i] = sc.nextDouble();
            if (salary[i] <= 0 || years[i] < 0) {
                i--;
                continue;
            }
        }
        for (int i = 0; i < 10; i++) {
            bonus[i] = (years[i] > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println(totalBonus + " " + totalOldSalary + " " + totalNewSalary);
    }
}
