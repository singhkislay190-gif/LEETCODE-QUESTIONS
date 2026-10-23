
import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        // Start with an empty string and zero brackets
        backtrack(result, "", 0, 0, n);

        return result;
    }

    void backtrack(List<String> result, String current,
                   int open, int close, int n) {

        // If the string has 2*n brackets, save it
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '(' if we have not used all opening brackets
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')' only if it can match an opening bracket
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
