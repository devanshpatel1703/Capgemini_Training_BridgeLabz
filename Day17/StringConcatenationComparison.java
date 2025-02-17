//3.

class StringConcatenationComparison {
    static String concatenateWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";
        }
        return result;
    }

    static String concatenateWithStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    static String concatenateWithStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return sb.toString();
    }

    static long measureTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        for (int size : datasetSizes) {
            long stringTime = measureTime(() -> concatenateWithString(size));
            long stringBuilderTime = measureTime(() -> concatenateWithStringBuilder(size));
            long stringBufferTime = measureTime(() -> concatenateWithStringBuffer(size));
            System.out.println("Operations Count: " + size);
            System.out.println("String Time: " + stringTime + " ms");
            System.out.println("StringBuilder Time: " + stringBuilderTime + " ms");
            System.out.println("StringBuffer Time: " + stringBufferTime + " ms");
            System.out.println("-".repeat(40));
        }
    }
}
