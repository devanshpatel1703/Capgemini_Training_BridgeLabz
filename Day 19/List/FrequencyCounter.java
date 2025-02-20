
import java.util.*;
public class FrequencyCounter{
    public static Map<String, Integer>countFrequency(List<String> list){
        Map<String, Integer> frequencyMap = new HashMap<>();

        for(String word: list){
            if(frequencyMap.containsKey(word)){
                frequencyMap.put(word, frequencyMap.get(word)+1);
            }else{
                frequencyMap.put(word, 1);
            }
        } 
        return frequencyMap;
    }

    public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(words);
        System.out.println(result);
	}
}