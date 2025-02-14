import java.util.Scanner;

public class CountingSort {

    public static int[] countingSortStudentAges(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[ages.length];

        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] studentAges = new int[n];
        System.out.println("Enter the ages of the students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = scanner.nextInt();
            while (studentAges[i] < 10 || studentAges[i] > 18) {
                System.out.println("Age must be between 10 and 18. Please enter again:");
                studentAges[i] = scanner.nextInt();
            }
        }

        int[] sortedAges = countingSortStudentAges(studentAges);

        System.out.println("Sorted Ages:");
        for (int age : sortedAges) {
            System.out.print(age + " ");
        }
    }
}
