public class FirstNegative {
    public int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNegative solution = new FirstNegative();

        int[] arr = {2, 4, -3, 6, 7}; 

        int index = solution.findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number is at index: " + index);
        } else {
            System.out.println("No negative number found");
        }
    }

    String findSentenceWithWord(String[] sentences, String word) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
