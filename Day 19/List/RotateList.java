import java.util.*;
public class RotateList{
    public static void rotateList(List<Integer> list, int  positions){
        int n = list.size();
        positions = positions % n;
        if (positions < 0) {
            positions += n;
        }

        reverse(list, 0, positions-1);
        reverse(list, positions, n-1);
        reverse(list, 0, n-1);
        
    }

    public static void reverse(List<Integer> list, int start, int end) {
        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    } 

    public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int positions = 2;

        rotateList(list, positions);
        System.out.println("Rotated List: " + list);
	}
}