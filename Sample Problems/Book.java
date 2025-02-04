class Book {
    static String libraryName="Unknown";
    String title="Unknown";
    String author="Unknown";
    final String isbn;
    public Book(String isbn, String title, String author,String libraryName){
        this.isbn = isbn;
        this.title = title;
        this.author=author;
        setLibraryName(libraryName);
    } 
    public static void setLibraryName(String name){
        libraryName = name;
    }
    public void display() {
        System.out.println(libraryName+"--"+title+"--"+author+"--"+isbn);
    }    
    public static void main(String[] args) {
        Book book = new Book("#isbn","booktitle","author","libraryname");
        Book book1 = new Book("#isbn","booktitle1","author","libraryname");
        book.display();
        if(book1 instanceof Book){
            book1.display();
        }
    }
}
