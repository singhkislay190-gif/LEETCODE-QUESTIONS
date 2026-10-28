
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            // Remove larger digits from the stack
            while (k > 0 && !stack.isEmpty()
                    && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If removals are still left, remove digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the answer
        StringBuilder result = new StringBuilder();

        for (char digit : stack) {
            result.append(digit);
        }

        // Remove leading zeros
        while (result.length() > 0
                && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // If no digits remain, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }
}
