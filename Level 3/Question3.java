class Ques3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0, originalNumber = number;
        while (originalNumber != 0) {
            sum += originalNumber % 10;
            originalNumber /= 10;
        }
        System.out.println(number % sum == 0 ? "Harshad Number" : "Not a Harshad Number");
    }
}