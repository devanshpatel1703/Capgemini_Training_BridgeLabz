import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] results = new int[10];
        for (int i = 1; i <= 10; i++) {
            results[i - 1] = number * i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + results[i]);
        }
    }
}