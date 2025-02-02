class Book2 {
    private String title;
    private String author; 
    private int price; 
    private boolean availability;
    public Book2(String title, String author, int price, boolean availability){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }
    public String borrowBook(){
        if(this.availability){
            return "You can borrow book "+ this.title;
        }
        else{
            return "You can not borrow book "+this.title;
        }
    }
    public static void main(String[] args) {
        Book2 obj = new Book2("Physics","HC V",2500,true);
        Book2 obj1 = new Book2("Chem","Heman",2550,false);
        System.out.println(obj.borrowBook());
        System.out.println(obj1.borrowBook());
    }    
}
