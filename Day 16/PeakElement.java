public class PeakElement {
    public int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            } 
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1; 
            } 
            else {
                left = mid + 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        PeakElement solution = new PeakElement();
        int[] arr = {1, 3, 20, 4, 1, 0};  

        int peakIndex = solution.findPeakElement(arr);
        System.out.println("A peak element is at index: " + peakIndex);
        System.out.println("Peak element is: " + arr[peakIndex]);
    }
}
