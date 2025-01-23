import java.util.*;
class Question12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0) {
            int sum = 0, i = 1;
            while (i <= number) {
                sum += i;
                i++;
            }
            int formulaSum = number * (number + 1) / 2;
            System.out.println("Sum using loop: " + sum + ", Sum using formula: " + formulaSum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}