
import java.util.Scanner;

public class Ques_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] frequency = new int[10];

        while (number > 0) {
            frequency[number % 10]++;
            number /= 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + frequency[i]);
        }
    }
}
