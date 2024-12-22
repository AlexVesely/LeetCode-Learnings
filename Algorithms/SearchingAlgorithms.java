package Algorithms;

import java.util.Arrays;
import java.util.List;

public class SearchingAlgorithms {

    // Ω(1), Θ(n), O(n)
    // Use for small unsorted arrays
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Return the index where key is found
            }
        }
        return -1; // Return -1 if key is not found
    }

    // Ω(1), Θ(log n), O(log n)
    // Use for sorted arrays
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; // Key found
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Key not found
    }

    // Ω(1), Θ(√n), O(√n)
    // Array needs to be sorted. Use instead of binary search for smaller memory usage
    public static int jumpSearch(int[] arr, int key) {
        int n = arr.length;
        int step = (int) Math.sqrt(n); // Size of jump
        int prev = 0;

        while (arr[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // Key not found
            }
        }

        for (int i = prev; i < Math.min(step, n); i++) { // Desired value is between this step and the next step
            if (arr[i] == key) {
                return i;
            }
        }

        return -1; // Key not found
    }

    // Ω(1), Θ(log n), O(log n)
    // Use for sorted arrays. Use instead of binary search when array size is unknown
    public static int exponentialSearch(int[] arr, int key) {
        if (arr[0] == key) {
            return 0;
        }

        int range = 1;
        while (range < arr.length && arr[range] <= key) {
            range *= 2;
        }

        return Arrays.binarySearch(arr, range / 2, Math.min(range, arr.length), key);
    }

    // Ω(1), Θ(log n), O(log n)
    // Built in binary search for sorted arrays.
    public static int builtInBinarySearch(int[] arr, int key) {
        return Arrays.binarySearch(arr, key);
    }

    // Ω(1), Θ(n), O(n)
    // A linear search on an unsorted linked list, returns true or false
    public static boolean contains(List<Integer> list, int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2, 5, 3, 10, 8, 99, 1}, 99));
    }

}
