public import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experience;

    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperience() {
        return experience;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return candidateName + " - " + getRole() + " (Experience: " + experience + " years)";
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }

    public String getRole() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }

    public String getRole() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }

    public String getRole() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private List<T> candidates = new ArrayList<>();

    public void addCandidate(T candidate) {
        candidates.add(candidate);
    }

    public List<T> getCandidates() {
        return candidates;
    }
}

class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> candidates) {
        System.out.println("Processing Resumes:");
        for (JobRole candidate : candidates) {
            System.out.println(candidate);
        }
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        softwareResumes.addCandidate(new SoftwareEngineer("Alice", 5));
        softwareResumes.addCandidate(new SoftwareEngineer("Bob", 3));

        Resume<DataScientist> dataScienceResumes = new Resume<>();
        dataScienceResumes.addCandidate(new DataScientist("Charlie", 4));
        dataScienceResumes.addCandidate(new DataScientist("David", 2));

        Resume<ProductManager> productManagerResumes = new Resume<>();
        productManagerResumes.addCandidate(new ProductManager("Eve", 6));
        productManagerResumes.addCandidate(new ProductManager("Frank", 5));

        System.out.println("Software Engineer Resumes:");
        ResumeScreeningSystem.processResumes(softwareResumes.getCandidates());

        System.out.println("\nData Scientist Resumes:");
        ResumeScreeningSystem.processResumes(dataScienceResumes.getCandidates());

        System.out.println("\nProduct Manager Resumes:");
        ResumeScreeningSystem.processResumes(productManagerResumes.getCandidates());
    }
} {
    
}
