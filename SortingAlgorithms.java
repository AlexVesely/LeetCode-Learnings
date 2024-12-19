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
            int key = arr[i]; // Current number to be inserted to its sorted position
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { // If there are still numbers on the left greater than key, shift them to the right
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

    // Ω(n log n), Θ(n log n), O(n²)
    // Ideal for large datasets when memory is limited.
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Recursive method to create partitions and quickSort them
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // Base case: if the low
            int pi = partition(arr, low, high); // Partition the array and get the pivot index
            quickSort(arr, low, pi - 1); // Recursively sort the sub-array before the pivot
            quickSort(arr, pi + 1, high); // Recursively sort the sub-array after the pivot
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Choose the pivot (last element of the array in this example)
        int pivot = arr[high];

        // i is the index of the smaller element
        int i = low - 1;

        // Loop through the array from low to high-1
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment i and swap arr[i] with arr[j]
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot (arr[high]) with the element at i + 1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the index where the pivot is placed (partition index)
        return i + 1;
    }

    public static void main(String[] args) {
        mergeSort(new int[]{2, 5, 3, 10, 8, 99, 1});
    }

}
