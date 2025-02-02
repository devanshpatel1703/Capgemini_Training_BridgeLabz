class Product {
    String productName;
    int price;
    static int totalProducts;
    public Product(String productName, int price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    public void displayProductDetails(){
        System.out.println(this.productName+"--"+this.price);
    }
    public static void displayTotalProducts(){
        System.out.println("Total products :"+totalProducts);
    }
    public static void main(String[] args) {
        Product p1=new Product("Maggie",15);
        Product p2=new Product("Pasta",15);
        Product p3=new Product("Namkeen",15);
        Product p4=new Product("Shit",100);
        p2.displayProductDetails();
        displayTotalProducts();
    }
}
