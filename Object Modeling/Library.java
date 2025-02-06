import java.util.ArrayList;
import java.util.*;
class Book {
   String title;
   String author;
   public Book(String title, String author) {
       this.title = title;
       this.author = author;
   }
   public void showBook() {
       System.out.println("Title: " + title + ", Author: " + author);
   }
}
class Library {
   String name;
   ArrayList<Book> books;
   public Library(String name) {
       this.name = name;
       this.books = new ArrayList<>();
   }
   public void addBook(Book book) {
       books.add(book);
   }
   public void show() {
       System.out.println("Library: " + name);
       for (Book book : books) {
           book.showBook();
       }
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Number of libraries: ");
       int numLibraries = sc.nextInt();
       sc.nextLine();
       ArrayList<Library> libraries = new ArrayList<>();

       for (int i = 0; i < numLibraries; i++) {
           System.out.print("Enter library name: ");
           String libraryName = sc.nextLine();
           Library library = new Library(libraryName);
           libraries.add(library);
           System.out.print("Enter number of books for " + libraryName + ": ");
           int numBooks = sc.nextInt();
           sc.nextLine();
           for (int j = 0; j < numBooks; j++){
               System.out.print("Enter book title: ");
               String title = sc.nextLine();
               System.out.print("Enter book author: ");
               String author = sc.nextLine();
               Book book = new Book(title, author);
               library.addBook(book);
           }
       }
       for (Library library : libraries) {
           library.show();
           System.out.println();
       }
   }
}