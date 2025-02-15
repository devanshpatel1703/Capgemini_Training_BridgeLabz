public class BinarySearchFirstLast {
    public int[] findFirstAndLast(int[] arr, int target) {
        int[] result = {-1, -1}; 
        
        result[0] = findFirstOccurrence(arr, target);
        if (result[0] == -1) {
            return result; 
        }
        
        result[1] = findLastOccurrence(arr, target);
        
        return result;
    }
    
    private int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return first;
    }
    
    private int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return last;
    }
    
    public static void main(String[] args) {
        BinarySearchFirstLast solution = new BinarySearchFirstLast();
        int[] arr = {1, 2, 3, 3, 3, 4, 5}; // Example sorted array
        
        int target = 3;
        int[] result = solution.findFirstAndLast(arr, target);
        
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
