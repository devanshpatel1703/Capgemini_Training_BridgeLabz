import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        }
    }

    public void displayCart() {
        System.out.println("Cart Items: " + cart);
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (String product : productPrices.keySet()) {
            sortedByPrice.put(productPrices.get(product), product);
        }
        System.out.println("Products Sorted by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000);
        cart.addProduct("Phone", 500);

        cart.addToCart("Laptop", 1);
        cart.addToCart("Phone", 2);

        cart.displayCart();
    }
}