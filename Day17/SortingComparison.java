//2.
import java.util.Random;

class SortingComparison {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static long measureTime(Runnable sortingFunction) {
        long startTime = System.nanoTime();
        sortingFunction.run();
        return (System.nanoTime() - startTime) / 1000000;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] arr = rand.ints(size, 0, size).toArray();
            int[] arrCopy1 = arr.clone();
            int[] arrCopy2 = arr.clone();
            int[] arrCopy3 = arr.clone();
            long bubbleTime = measureTime(() -> bubbleSort(arrCopy1));
            long mergeTime = measureTime(() -> mergeSort(arrCopy2, 0, arrCopy2.length - 1));
            long quickTime = measureTime(() -> quickSort(arrCopy3, 0, arrCopy3.length - 1));
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleTime + " ms");
            System.out.println("Merge Sort Time: " + mergeTime + " ms");
            System.out.println("Quick Sort Time: " + quickTime + " ms");
            System.out.println("-".repeat(40));
        }
    }
}
