package DataStructures;

import java.util.Arrays;

public class StringLearning {
    // Manipulate a String by reversing it
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) { // Swap characters until the pointers meet in the middle
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars); // Convert the character array back to a string
    }

    // Manipulate a String by reversing it, this one uses built in StringBuilder method
    public static String builtInReverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // How to check if two Strings are anagrams? Convert to characters and then sort them!
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    // A way to check if two strings are anagrams without any imports
    public static boolean areAnagramsNOIMPORTS(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Assuming only lowercase a-z letters

        // Count characters from the first string
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
        }

        // Subtract the count for characters in the second string
        for (int i = 0; i < str2.length(); i++) {
            charCount[str2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false; // If any count is not zero, they're not anagrams
            }
        }

        return true; // All counts are zero, so they're anagrams
    }

    // Finding whether a substring exists in a string.
    public static boolean containsSubstring(String str, String sub) {
        return str.contains(sub); // Built-in method for simplicity
    }

    // Find whether a string is a palindrome or not
    // String is an array of chars!
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hablop"));
    }
}
