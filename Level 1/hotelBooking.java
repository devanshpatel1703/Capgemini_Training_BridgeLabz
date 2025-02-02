class hotelBooking {
    private String name;
    private String roomType;
    private int night;
    public hotelBooking(){
        this.name="Unknown";
        this.roomType="Unknown";
        this.night=0;
    }
    public hotelBooking(String name ,String roomType, int night){
        this.name=name;
        this.roomType=roomType;
        this.night=night;
    }
    public hotelBooking(hotelBooking obj){
        this.name=obj.name;
        this.roomType=obj.roomType;
        this.night=obj.night;
    }
    public String display(){
        return this.name+"--"+this.roomType+"--"+""+this.night;
    }
    public static void main(String[] args) {
        hotelBooking obj = new hotelBooking("Dev","single",2);
        hotelBooking obj1 = new hotelBooking(obj);
        System.out.println(obj.display());
        System.out.println(obj1.display());

    }    
}
