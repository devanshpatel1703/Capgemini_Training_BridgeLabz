import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head;
    private Movie tail;

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        temp.next = newMovie;
    }

    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
    }

    public void searchMovieByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Rating: " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void searchMovieByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Directed by: " + temp.director);
            }
            temp = temp.next;
        }
    }

    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " (" + temp.year + ") - " + temp.director + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        while (true) {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Movie Title: ");
                    scanner.nextLine(); 
                    String title = scanner.nextLine();
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = scanner.nextDouble();
                    if (choice == 1) movieList.addMovieAtBeginning(title, director, year, rating);
                    else if (choice == 2) movieList.addMovieAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Enter Position: ");
                        int position = scanner.nextInt();
                        movieList.addMovieAtPosition(title, director, year, rating, position);
                    }
                    break;
                case 4:
                    System.out.print("Enter Movie Title to Remove: ");
                    scanner.nextLine();
                    movieList.removeMovie(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Director: ");
                    scanner.nextLine();
                    movieList.searchMovieByDirector(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Rating: ");
                    movieList.searchMovieByRating(scanner.nextDouble());
                    break;
                case 7:
                    System.out.print("Enter Movie Title to Update Rating: ");
                    scanner.nextLine();
                    title = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = scanner.nextDouble();
                    movieList.updateMovieRating(title, rating);
                    break;
                case 8:
                    movieList.displayMoviesForward();
                    break;
                case 9:
                    movieList.displayMoviesReverse();
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
