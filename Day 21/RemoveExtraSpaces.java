public class RemoveExtraSpaces {
    public static void main(String[] args) {
        String text = "This  is   an  example    with  multiple    spaces.";
        String cleanedText = text.replaceAll("\\s+", " ").trim();
        System.out.println(cleanedText); // Output: "This is an example with multiple spaces."
    }
}
