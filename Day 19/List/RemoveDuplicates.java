import java.util.*;

public class RemoveDuplicates{
    public static List<Integer> removeDuplicates(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer element : list){
            if(!result.contains(element)){
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(2,3,2,5,3,4,6,1,9,7,4));
        List<Integer> output = removeDuplicates(list);
        System.out.println("Duplicates Removed list: "+ output);
	}
}