import java.util.*;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.put(entry.getKey(), mergedMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        System.out.println(mergedMap);
    }
}