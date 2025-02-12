import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private Item head;

    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found!");
            return;
        }
        temp.next = temp.next.next;
    }

    public void updateItemQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully!");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void displayItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Remove Item");
            System.out.println("4. Update Item Quantity");
            System.out.println("5. Search Item by ID");
            System.out.println("6. Search Item by Name");
            System.out.println("7. Calculate Total Inventory Value");
            System.out.println("8. Display All Items");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    if (choice == 1) inventory.addItemAtBeginning(itemName, itemId, quantity, price);
                    else inventory.addItemAtEnd(itemName, itemId, quantity, price);
                    break;
                case 3:
                    System.out.print("Enter Item ID to Remove: ");
                    inventory.removeItem(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Item ID to Update Quantity: ");
                    itemId = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    quantity = scanner.nextInt();
                    inventory.updateItemQuantity(itemId, quantity);
                    break;
                case 5:
                    System.out.print("Enter Item ID: ");
                    inventory.searchItemById(scanner.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Item Name: ");
                    scanner.nextLine();
                    inventory.searchItemByName(scanner.nextLine());
                    break;
                case 7:
                    inventory.calculateTotalValue();
                    break;
                case 8:
                    inventory.displayItems();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
