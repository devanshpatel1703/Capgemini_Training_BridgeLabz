class Devices {
    int id;
    boolean status;

    public Devices(int id, boolean status) {
        this.id = id;
        this.status = status;
    }
}

class Thermostat extends Devices {
    int temprature;

    public Thermostat(int temprature, boolean status, int id) {
        super(id, status);
        this.temprature = temprature;
    }

    public void displayStatus() {
        System.out.println(this.temprature + "--" + this.status + "--" + this.id);
    }
}

class Ques2 {
    public static void main(String[] args) {
        Thermostat obj = new Thermostat(45, false, 1);
        obj.displayStatus();
    }
}
