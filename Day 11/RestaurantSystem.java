// Base class: Person
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id); // Call superclass constructor
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking delicious meals.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id); // Call superclass constructor
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving customers.");
    }
}

// Main class
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101);
        chef.displayDetails();
        chef.performDuties();

        Waiter waiter = new Waiter("Alice", 102);
        waiter.displayDetails();
        waiter.performDuties();
    }
}