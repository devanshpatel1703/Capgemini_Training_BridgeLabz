class Vehicle {
    static int registrationFee = 500;  
    static int totalVehicles = 0;  

    String ownerName;
    String vehicleType;
    final int registrationNumber;  

    public Vehicle(String ownerName, String vehicleType, int registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        totalVehicles++;  
    }

    public static void updateRegistrationFee(int newFee) {
        registrationFee = newFee;
    }

    public static void displayTotalVehicles() {
        System.out.println("Total Registered Vehicles: " + totalVehicles);
    }

    public void displayVehicleInfo() {
        System.out.println(ownerName + " | Vehicle Type: " + vehicleType + " | Reg No: " + registrationNumber + " | Fee: " + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "Car", 101);
        Vehicle v2 = new Vehicle("Jane Smith", "Motorbike", 102);

        if (v1 instanceof Vehicle) {
            v1.displayVehicleInfo();
        }
        if (v2 instanceof Vehicle) {
            v2.displayVehicleInfo();
        }

        displayTotalVehicles();
    }
}
