import java.util.*;
public class reversedList{

    public static void reversedArrayList(ArrayList<Integer> list){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void reversedLinkedList(LinkedList<Integer> list){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        reversedArrayList(arrayList);
        reversedLinkedList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);
	}
}