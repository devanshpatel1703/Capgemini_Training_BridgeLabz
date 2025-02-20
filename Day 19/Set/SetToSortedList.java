import java.util.*;
public class SetToSortedList {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 9, 3));

        List<Integer> list = new ArrayList<>();
        for(Integer i : set1){
            list.add(i);
        }

        int n = list.size();
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(list.get(i)>list.get(j)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        
        System.out.println("Sorted List :- " + list);
    }
}
