class Vehicle {
    String ownerName="Unknown";
    String vehicleType="Unknown";
    static int registrationFee=5000;
    public Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails(){
        System.out.println(this.ownerName+"--"+this.vehicleType+"--"+registrationFee);
    }
    public static void updateRegistrationFee(int n){
        registrationFee = n;
    }
    public static void main(String[] args) {
        Vehicle obj=new Vehicle("Ayush","Vickey");
        obj.displayVehicleDetails();
        updateRegistrationFee(6000);
        obj.displayVehicleDetails();
    }
}
