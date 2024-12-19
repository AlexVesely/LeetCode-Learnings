import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgorithms {

    // Simple to implement but inefficient O(n²) complexity
    // Use for small arrays
    public static void bubbleSort(int[] array) {
        System.out.println(Arrays.toString(array));
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // After each outer loop the largest number will be bubbled to the end
            for (int j = 0; j < n - 1 - i; j++) { // Each inner loop compares and swaps numbers so they are ordered
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }


    public static void main(String[] args) {
        bubbleSort(new int[]{9, 5, 3, 99, 1});
    }


}
