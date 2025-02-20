import java.util.*;
public class UnionAndIntersection {

    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();

        for (Integer element : set1) {
                if (set2.contains(element)) {
                    intersection.add(element);
                }
           
            
        }
        return intersection;
    }

    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> union = new HashSet<>();

        for(Integer element : set1){
            union.add(element);
        } 

        for(Integer element : set2){
            if(!union.contains(element)){
                union.add(element);
            }
        }       
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 2, 1,2,6,3));
        
        Set<Integer> intersection = findIntersection(set1, set2);
        Set<Integer> union = findUnion(set1, set2);
        System.out.println("Intersection :- " + intersection);
        System.out.println("Union :- " + union);
    }
}
