package LeetCodeProblems.LengthOfLastWord_58;

public class LengthOfLastWordSubmission {

    public static int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int index = charArray.length - 1;
        boolean hasLastWordBeenFound = false;

        // Move backward to find the last non-space character
        while (!hasLastWordBeenFound && index >= 0) {
            if (charArray[index] != ' ') {
                hasLastWordBeenFound = true;
            } else {
                index--;
            }
        }

        boolean hasWordTerminated = false;
        int wordLength = 0;

        // Count characters until we hit a space OR the start of the array
        while (!hasWordTerminated && index >= 0) {
            if (charArray[index] == ' ') {
                hasWordTerminated = true;
            } else {
                wordLength++;
                index--;
            }
        }

        return wordLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello War  "));
    }
}
