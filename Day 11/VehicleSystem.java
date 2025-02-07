// Base class: Vehicle
class Vehicle {
    protected double maxSpeed;
    protected String model;

    public Vehicle(double maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(double maxSpeed, String model) {
        super(maxSpeed, model); // Call superclass constructor
    }

    public void charge() {
        System.out.println("Charging the electric vehicle: " + model);
    }
}

// Subclass: PetrolVehicle
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(double maxSpeed, String model) {
        super(maxSpeed, model); // Call superclass constructor
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle: " + model);
    }
}

// Main class
public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(120, "Tesla Model S");
        ev.displayDetails();
        ev.charge();

        PetrolVehicle pv = new PetrolVehicle(180, "Toyota Camry");
        pv.displayDetails();
        pv.refuel();
    }
}