import java.util.*;
class Question13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0) {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            int formulaSum = number * (number + 1) / 2;
            System.out.println("Sum using loop: " + sum + ", Sum using formula: " + formulaSum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}