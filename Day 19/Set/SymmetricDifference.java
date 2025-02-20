import java.util.*;
public class SymmetricDifference {

    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> symmetricSet = new HashSet<>();

        for (Integer element : set1) {
                if (!set2.contains(element)) {
                    symmetricSet.add(element);
                }
            
        }

        for (Integer element : set2) {
                if (!set1.contains(element)) {
                    symmetricSet.add(element);
                }
            
        }
        return symmetricSet;
    }


    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        
        Set<Integer> symmetricSet = symmetricDifference(set1, set2);
        System.out.println("SymmetricDifference :- " + symmetricSet);
    }
}
