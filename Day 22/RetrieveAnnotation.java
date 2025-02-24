import java.lang.annotation.Annotation;

public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Book.class;

            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
