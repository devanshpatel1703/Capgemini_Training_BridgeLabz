import java.util.ArrayList;
import java.util.List;

// Product Class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

// Order Class
class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products in this order:");
        for (Product product : products) {
            System.out.println("- " + product);
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

// Customer Class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrderHistory() {
        System.out.println("Order history for " + name + ":");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

public class ECommercePlatformDemo {
    public static void main(String[] args) {
        // Create some products
        Product laptop = new Product("Laptop", 1000.00);
        Product smartphone = new Product("Smartphone", 700.00);
        Product headphones = new Product("Headphones", 100.00);

        // Create a customer
        Customer rahul = new Customer("Rahul Chaudhary");

        // Create an order for John Doe
        Order order1 = new Order(101, rahul);
        order1.addProduct(laptop);
        order1.addProduct(headphones);

        // Rahul places the order
        rahul.placeOrder(order1);

        // Create another order
        Order order2 = new Order(102, rahul);
        order2.addProduct(smartphone);

        // Rahul places the second order
        rahul.placeOrder(order2);

        // Show order history for Rahul
        rahul.showOrderHistory();
    }
}