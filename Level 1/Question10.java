import java.util.*;
class Question10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double total = 0.0, number;
        do {
            number = input.nextDouble();
            total += number;
        } while (number != 0);
        System.out.println("The total sum is " + total);
    }
}
