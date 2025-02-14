import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(double[] bookPrices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(bookPrices, left, mid);
            mergeSort(bookPrices, mid + 1, right);
            
            merge(bookPrices, left, mid, right);
        }
    }

    public static void merge(double[] bookPrices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
        
        for (int i = 0; i < n1; i++)
            leftArray[i] = bookPrices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = bookPrices[mid + 1 + j];
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                bookPrices[k] = leftArray[i];
                i++;
            } else {
                bookPrices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            bookPrices[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            bookPrices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of books: ");
        int n = scanner.nextInt();
        double[] bookPrices = new double[n];
        
        System.out.println("Enter the book prices: ");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextDouble();
        }
        
        mergeSort(bookPrices, 0, n - 1);
        
        System.out.print("Sorted book prices: ");
        for (double price : bookPrices) {
            System.out.print(price + " ");
        }
        
    }
}
