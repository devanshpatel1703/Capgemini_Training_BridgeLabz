class Patient {
    static String hospitalName = "Unknown Hospital";  
    static int totalPatients = 0;  

    String name;
    int age;
    String ailment;
    final int patientID;  

    public Patient(String name, int age, String ailment, int patientID, String hospital) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        setHospitalName(hospital);
        totalPatients++;  
    }

    public static void setHospitalName(String hospital) {
        hospitalName = hospital;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayPatientInfo() {
        System.out.println(name + " | Age: " + age + " | Ailment: " + ailment + " | Patient ID: " + patientID + " | " + hospitalName);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Fever", 101, "City Hospital");
        Patient p2 = new Patient("Bob", 45, "Diabetes", 102, "City Hospital");

        if (p1 instanceof Patient) {
            p1.displayPatientInfo();
        }
        if (p2 instanceof Patient) {
            p2.displayPatientInfo();
        }

        getTotalPatients();
    }
}
