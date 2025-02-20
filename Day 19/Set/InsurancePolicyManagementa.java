package set;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(policyNumber); }

    @Override
    public int compareTo(InsurancePolicy other) { return this.expiryDate.compareTo(other.expiryDate); }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementa {
    private Set<InsurancePolicy> policyHashSet = new HashSet<>();
    private Set<InsurancePolicy> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> policyTreeSet = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (HashSet - Unordered): " + policyHashSet);
        System.out.println("All Policies (LinkedHashSet - Insertion Order): " + policyLinkedHashSet);
        System.out.println("All Policies (TreeSet - Sorted by Expiry Date): " + policyTreeSet);
    }

    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        policyTreeSet.stream().filter(p -> p.getExpiryDate().isBefore(limit)).forEach(System.out::println);
    }

    public void displayByCoverageType(String type) {
        policyHashSet.stream().filter(p -> p.getCoverageType().equalsIgnoreCase(type)).forEach(System.out::println);
    }

    public void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : policyHashSet) {
            if (!seen.add(policy.getPolicyNumber())) duplicates.add(policy);
        }
        System.out.println("Duplicate Policies: " + duplicates);
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        manager.addPolicy(new InsurancePolicy("P123", "John Doe", "2025-05-15", "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P456", "Alice Smith", "2024-07-15", "Auto", 3000));
        manager.addPolicy(new InsurancePolicy("P789", "Bob Johnson", "2024-08-01", "Home", 4500));
        manager.addPolicy(new InsurancePolicy("P123", "John Doe", "2025-05-15", "Health", 5000)); // Duplicate

        manager.displayAllPolicies();
        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        manager.displayExpiringSoon();
        System.out.println("\nPolicies with Coverage Type 'Auto':");
        manager.displayByCoverageType("Auto");
        System.out.println("\nChecking for Duplicate Policies:");
        manager.findDuplicatePolicies();
    }
}