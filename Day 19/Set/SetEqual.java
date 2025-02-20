import java.util.*;
public class SetEqual {

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() != set2.size()) {
            return false;
        }

        for (Integer element1 : set1) {
            boolean found = false;
            for (Integer element2 : set2) {
                if (element1.equals(element2)) {
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
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        
        boolean result = areSetsEqual(set1, set2);
        System.out.println("Sets equal:- " + result);
    }
}
