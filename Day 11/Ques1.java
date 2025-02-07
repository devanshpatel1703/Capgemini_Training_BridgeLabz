class Book {
    String title;
    int pulicationYear;

    public Book(String title, int pulicationYear) {
        this.title = title;
        this.pulicationYear = pulicationYear;
    }
}

class Author extends Book {
    String name;
    String bio;

    public Author(String name, String bio, String title, int pulicationYear) {
        super(title, pulicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println(title + "--" + pulicationYear + "--" + name + "--" + bio);
    }
}

class Ques1 {
    public static void main(String[] args) {
        Author obj = new Author("Devansh", "Mybio", "Life story", 2003);
        obj.displayInfo();
    }
}