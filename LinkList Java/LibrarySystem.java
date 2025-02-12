import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head;
    private Book tail;
    private int count;

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void removeBook(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                count--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    public void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", Available: " + temp.isAvailable + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    public void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", Available: " + temp.isAvailable + ")");
            }
            temp = temp.next;
        }
    }

    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability status updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", Available: " + temp.isAvailable + ")");
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", Available: " + temp.isAvailable + ")");
            temp = temp.prev;
        }
    }

    public void countTotalBooks() {
        System.out.println("Total books in the library: " + count);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Remove Book");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Search Book by Author");
            System.out.println("6. Update Availability Status");
            System.out.println("7. Display Books Forward");
            System.out.println("8. Display Books Reverse");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter Book Title: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter Availability Status (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    if (choice == 1) library.addBookAtBeginning(title, author, genre, bookId, isAvailable);
                    else library.addBookAtEnd(title, author, genre, bookId, isAvailable);
                    break;
                case 3:
                    System.out.print("Enter Book ID to Remove: ");
                    library.removeBook(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Book Title: ");
                    scanner.nextLine();
                    library.searchBookByTitle(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Author: ");
                    scanner.nextLine();
                    library.searchBookByAuthor(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Book ID to Update Availability: ");
                    bookId = scanner.nextInt();
                    System.out.print("Enter New Availability Status (true/false): ");
                    isAvailable = scanner.nextBoolean();
                    library.updateAvailabilityStatus(bookId, isAvailable);
                    break;
                case 7:
                    library.displayBooksForward();
                    break;
                case 8:
                    library.displayBooksReverse();
                    break;
                case 9:
                    library.countTotalBooks();
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}