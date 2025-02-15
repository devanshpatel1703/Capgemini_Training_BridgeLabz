import java.util.Arrays;

public class SearchAndFind {
    
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }

    public int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);  

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;  
    }

    public static void main(String[] args) {
        SearchAndFind solution = new SearchAndFind();

        int[] arr1 = {3, 4, -1, 1};
        System.out.println("First Missing Positive: " + solution.firstMissingPositive(arr1));

        int[] arr2 = {5, 2, 1, 8, 4, 7};
        int target = 4;
        System.out.println("Index of target " + target + ": " + solution.binarySearch(arr2, target));
    }
}
