import java.util.Arrays;

public class SortingAlgorithms {

    // Ω(n), Θ(n²), O(n²)
    // Use for small arrays
    public static void bubbleSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // After each outer loop the largest number will be bubbled to the end
            for (int j = 0; j < n - 1 - i; j++) { // Each inner loop compares and swaps numbers so they are ordered
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    // Ω(n²), Θ(n²), O(n²)
    // Use for small arrays
    public static void selectionSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // In the outer loop keep placing the found min index at its place
            int minIndex = i;
            for (int j = i + 1; j < n; j++) { // In the inner loop find the min index
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    // Ω(n), Θ(n²), O(n²)
    // Use for small arrays or nearly sorted arrays
    public static void insertionSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { // If there are still numbers on the left greater than key, swap them
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }

    // https://www.geeksforgeeks.org/merge-sort/
    // Ω(n log n), Θ(n log n), O(n log n)
    // Good for large datasets, but uses more memory for temporary arrays/recursion
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // Recursive method to divide arrays into smaller parts until a part has 0 or 1 number(s).
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // Base case if left > right return by doing nothing
            int mid = left + (right - left) / 2; // Find midpoint
            mergeSort(arr, left, mid); // Sort first half
            mergeSort(arr, mid + 1, right); // Sort second half
            merge(arr, left, mid, right); // merge sorted halves
        }
    }

    // Merges 2 sub arrays of array
    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of the two sub arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays to perform merge without affecting ongoing comparisons
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Initial indices of first and second sub arrays
        int i = 0;
        int j = 0;
        int k = left;

        // Merging step, compares numbers from the left and right sub arrays and orders them
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        mergeSort(new int[]{2, 5, 3, 10, 8, 99, 1});
    }


}
