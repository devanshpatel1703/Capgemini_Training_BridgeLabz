import java.util.*;
public class TotalPurchase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter unit price: ");
        double unitPrice = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.println("The total purchase price is INR " + (unitPrice * quantity) + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}
