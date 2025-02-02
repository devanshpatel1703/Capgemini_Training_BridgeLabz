class Book3 {
    int ISBN;
    protected String title;
    private String author;
    public Book3(int ISBN,String title,String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void display(){
        System.out.println(this.ISBN+"--"+this.title+"--"+this.author);
    }
    public static void main(String[] args) {
        Ebook obj=new Ebook(1234, "Shiva", "Dinesh");
        obj.display();
    }
}
class Ebook extends Book3{
    public Ebook(int ISBN,String title,String author){
        super(ISBN,title,author);
    }
    public int getISBN(){
        return this.ISBN;
    }
    public String getTitle(){
        return this.title;
    }
}
