import java.util.*;
class Question16 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                System.out.println(i + (i % 2 == 0 ? " is Even" : " is Odd"));
            }
        } else {
            System.out.println("Not a natural number");
        }
    }
}