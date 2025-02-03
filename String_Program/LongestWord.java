import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        String longestWord = "";
        String currentWord = "";
        
        for (int i = 0; i <= sentence.length(); i++) {
            char c = (i < sentence.length()) ? sentence.charAt(i) : ' ';
            
            if (c != ' ') {
                currentWord += c;
            } else {
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
                currentWord = ""; 
            }
        }

        System.out.println("Longest word: " + longestWord);
    }
}
