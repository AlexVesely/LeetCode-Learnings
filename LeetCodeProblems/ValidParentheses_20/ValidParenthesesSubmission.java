package LeetCodeProblems.ValidParentheses_20;

import java.util.Stack;

public class ValidParenthesesSubmission {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // else, it must be a closing bracket
            else {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // Check if the closing bracket matches the top of the stack
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty at the end then all brackets were properly matched
        return stack.isEmpty();
    }
}
