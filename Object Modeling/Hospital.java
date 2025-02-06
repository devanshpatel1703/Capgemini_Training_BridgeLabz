import java.util.ArrayList;
import java.util.List;

// Define Patient Class
class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doc) {
        if (!doctors.contains(doc)) {
            doctors.add(doc);
            doc.addPatient(this); // Maintain bidirectional relationship
        }
    }

    public void showConsultedDoctors() {
        System.out.println(name + " has consulted the following doctors:");
        for (Doctor doc : doctors) {
            System.out.println("Dr. " + doc.getName());
        }
    }
}

// Define Doctor Class
class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting patient " + patient.getName());
        addPatient(patient);
    }

    public void showConsultedPatients() {
        System.out.println("Dr. " + name + " has consulted the following patients:");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

// Define Hospital Class
class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showDoctors() {
        System.out.println("Doctors at " + hospitalName + ":");
        for (Doctor doctor : doctors) {
            System.out.println("- Dr. " + doctor.getName());
        }
    }

    public void showPatients() {
        System.out.println("Patients at " + hospitalName + ":");
        for (Patient patient : patients) {
            System.out.println(patient.getName());
        }
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Create doctors
        Doctor rahul = new Doctor("Rahul Chaudhary");
        Doctor varsha = new Doctor("Varsha Rawat");

        // Create patients
        Patient hemant = new Patient("Hemant Rawat");
        Patient gaurav = new Patient("Gaurav Rawat");

        // Add doctors and patients to the hospital
        hospital.addDoctor(rahul);
        hospital.addDoctor(varsha);
        hospital.addPatient(hemant);
        hospital.addPatient(gaurav);

        // Perform consultations
        rahul.consult(hemant);
        rahul.consult(gaurav);
        varsha.consult(gaurav);

        // Show doctors and their patients
        rahul.showConsultedPatients();
        varsha.showConsultedPatients();

        // Show patients and their doctors
        hemant.showConsultedDoctors();
        gaurav.showConsultedDoctors();

        // Display hospital details
        hospital.showDoctors();
        hospital.showPatients();
    }
}