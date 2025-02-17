//5.

class FibonacciComparison {
    static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    static long measureTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};
        for (int n : testCases) {
            long recursiveTime = measureTime(() -> fibonacciRecursive(n));
            long iterativeTime = measureTime(() -> fibonacciIterative(n));
            System.out.println("Fibonacci(" + n + "):");
            System.out.println("Recursive Time: " + recursiveTime + " ms");
            System.out.println("Iterative Time: " + iterativeTime + " ms");
            System.out.println("-".repeat(40));
        }
    }
}
