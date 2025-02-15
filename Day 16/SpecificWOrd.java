import java.util.Scanner;

public class SpecificWOrd {
    public String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FirstNegative solution = new FirstNegative();

        System.out.println("Enter number of sentences:");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        System.out.println("Enter the word to search:");
        String word = scanner.nextLine();

        String result = solution.findSentenceWithWord(sentences, word);
        System.out.println(result);
    }
}
