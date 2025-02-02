class CarRental{
    private String name;
    private String modal;
    private int days;
    final int cost =5;
    public CarRental(String name, String modal, int days) {
        this.name = name;
        this.modal = modal;
        this.days = days;
    }
    public int getCost(){
        return this.days*cost;
    }
    public static void main(String[] args) {
        CarRental obj=new CarRental("Maruti", "Dezire", 8);
        System.out.println("Your rental cost is :"+obj.getCost());
    }
}