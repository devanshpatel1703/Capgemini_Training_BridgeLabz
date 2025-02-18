import java.util.ArrayList;
import java.util.List;

public abstract class MarketPlace {
    private String name;
    private double price;

    public MarketPlace(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract String getCategory();
}

class Book extends MarketPlace {
    public Book(String name, double price) { super(name, price); }
    public String getCategory() { return "Book"; }
}

class Clothing extends MarketPlace {
    public Clothing(String name, double price) { super(name, price); }
    public String getCategory() { return "Clothing"; }
}

class Gadget extends MarketPlace {
    public Gadget(String name, double price) { super(name, price); }
    public String getCategory() { return "Gadget"; }
}

class ProductCatalog<T extends MarketPlace> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) { products.add(product); }
    public List<T> getProducts() { return products; }
}

class DiscountManager {
    public static <T extends MarketPlace> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

public class Marketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();

        Book book = new Book("Java Programming", 50);
        Clothing shirt = new Clothing("T-Shirt", 20);

        bookCatalog.addProduct(book);
        clothingCatalog.addProduct(shirt);

        DiscountManager.applyDiscount(book, 10);
        DiscountManager.applyDiscount(shirt, 15);

        System.out.println(book.getName() + " after discount: $" + book.getPrice());
        System.out.println(shirt.getName() + " after discount: $" + shirt.getPrice());
    }
}
    