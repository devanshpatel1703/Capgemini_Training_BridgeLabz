class Ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0, originalNumber = number;
        while (originalNumber != 0) {
            int remainder = originalNumber % 10;
            sum += remainder * remainder * remainder;
            originalNumber /= 10;
        }
        System.out.println(sum == number ? "Armstrong Number" : "Not an Armstrong Number");
    }
}