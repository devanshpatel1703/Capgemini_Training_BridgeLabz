import java.util.*;

public class SubsetCheck {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        for (Integer element : set1) {
            boolean found = false;
            for (Integer value : set2) {
                if (element.equals(value)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 5,6,9,3,4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList( 2, 3, 4));

        int size1 = set1.size();
        int size2 = set2.size();

        if (size1 == size2) {
            if (isSubset(set1, set2) && isSubset(set2, set1)) {
                System.out.println("Both sets are equal.");
            } else {
                System.out.println("Neither set is a subset of the other.");
            }
        } else if (size1 < size2) {
            if (isSubset(set1, set2)) {
                System.out.println("Set1 is a subset of Set2.");
            } else {
                System.out.println("Set1 is not a subset of Set2.");
            }
        } else { 
            if (isSubset(set2, set1)) {
                System.out.println("Set2 is a subset of Set1.");
            } else {
                System.out.println("Set2 is not a subset of Set1.");
            }
        }
    }
}