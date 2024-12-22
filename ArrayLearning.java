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

    // Find whether a string is a palindrome or not
    // String is an array of chars!
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
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

    public static void main(String[] args) {
        System.out.println(maxSumSubarray(new int[]{3,2,1,10,2,4,5,1,1,4,6,7,8},3));
    }

}

