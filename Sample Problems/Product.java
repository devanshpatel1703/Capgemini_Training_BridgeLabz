class Product {
    static int discount=0;
    static int instance=0;
    String productName="Unknown";
    int price=0;
    int quantity=0;
    final int productID;
    public Product(String productName, int price, int quantity, int productID,int discount) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
        setDiscount(discount);
        instance++;
    }
    public static void setDiscount(int n){
        discount = n;
    }
    public static void displayTotalProducts(){
        System.out.println("Number of products :"+instance);
    }
    public void display(){
        System.out.println(productName+"--"+price+"--"+quantity+"--"+productID+"--"+discount);
    }
    public static void main(String[] args) {
        Product obj=new Product("Maggie",15,10,169,10);
        Product obj1=new Product("Maggie",15,10,169,10);
        obj.display();
        if(obj1 instanceof Product){
            displayTotalProducts();
        }
    }
}
