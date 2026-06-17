package DataStructures;
import java.util.Arrays;

public class ArrayLearning {

    //ARRAYS

    public static void arrayBasics(){
        int[] arr1 = new int[3];
        arr1[0] = 9;
        arr1[1] = 4;
        arr1[2] = 55;

        int[] arr2 = {1, 2, 3, 4, 5};

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        for (int num : arr2) {
            System.out.println(num);
        }
    }

    //ARRAY POINTER PROBLEMS
    // Use when different parts of an array are compared

    // Find a pair in an array that adds up to a given sum
    // Array must be ordered
    public static boolean hasPairWithSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) { // Found sum is too small
                left++;
            } else {
                right--; // Found sum is too big
            }
        }
        return false;
    }

    //ARRAY SLIDING WINDOW PROBLEMS
    // Use when working with sub arrays

    // Find the Maximum Sum of a sub array size k
    // Instead of using two for loops use a sliding window
    // There will be array.length - k, windows checked
    public static int maxSumSubarray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE; //Smallest possible value, so  first max value found will be max value
        int sum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end]; // Add current element to the window

            if (end - start + 1 == k) {         // If window size = k
                maxSum = Math.max(maxSum, sum); // Update maxSum
                sum -= arr[start];              // Remove the element going out of the window
                start++;                        // Slide the window
            }
        }
        return maxSum;
    }

    public static void arraysClassLearning() {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a));
        int[] b = Arrays.copyOf(a,4);
        System.out.println(Arrays.toString(b));
        int[] c = Arrays.copyOf(a, 6); // Will add zeroes to the extra spaces
        System.out.println(Arrays.toString(c));
        int[] d = Arrays.copyOf(a, 2); // Will remove the last 2 indexes
        System.out.println(Arrays.toString(d));
        int[] e = Arrays.copyOfRange(a,1,3);
        System.out.println(Arrays.toString(e));

        // USE Arrays.equals(a1,a2) to compare that 2 arrays with the same contents are equal
        // USE Arrays.deepEquals(a1,a2) to compare the 2 2D,3D,4D... arrays with the contents are equal

        int[] all2s = new int[10];
        Arrays.fill(all2s, 2);
        System.out.println(Arrays.toString(all2s));
    }

    public static void main(String[] args) {
        arraysClassLearning();
    }

}

