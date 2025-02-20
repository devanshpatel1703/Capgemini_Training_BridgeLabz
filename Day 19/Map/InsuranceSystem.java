import java.util.*;

class Policy {
    String policyNumber, policyholderName, coverageType;
    Date expiryDate;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " - " + policyholderName + " (" + coverageType + ")";
    }
}

class PolicyManagement {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> policyOrder = new LinkedHashMap<>();
    TreeMap<Date, Policy> sortedPolicies = new TreeMap<>();

    void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        policyOrder.put(policy.policyNumber, policy);
        sortedPolicies.put(policy.expiryDate, policy);
    }

    Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    List<Policy> getExpiringPolicies(Date today) {
        List<Policy> expiring = new ArrayList<>();
        for (Date date : sortedPolicies.keySet()) {
            if (date.before(new Date(today.getTime() + (30L * 24 * 60 * 60 * 1000)))) {
                expiring.add(sortedPolicies.get(date));
            }
        }
        return expiring;
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {
        PolicyManagement system = new PolicyManagement();
        system.addPolicy(new Policy("P123", "Alice", new Date(2025, 1, 15), "Health", 5000));
        System.out.println("Policy Retrieved: " + system.getPolicy("P123"));
    }
}