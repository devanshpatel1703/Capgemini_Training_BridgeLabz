public class RotatedSortedArray {
    public int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RotatedSortedArray solution = new RotatedSortedArray();
        int[] arr = {6, 7, 9, 15, 19, 2, 3};  // Example rotated sorted array

        int rotationPoint = solution.findRotationPoint(arr);
        System.out.println("The index of the smallest element (rotation point) is: " + rotationPoint);
    }
}
