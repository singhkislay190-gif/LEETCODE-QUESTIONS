
import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        // If input is empty, return an empty list
        if (digits.length() == 0) {
            return result;
        }

        // Mapping of digits to letters
        String[] phone = {
            "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };

        // Start building combinations
        backtrack(digits, 0, "", phone, result);

        return result;
    }

    void backtrack(String digits, int index, String current,
                   String[] phone, List<String> result) {

        // If all digits are used, save the combination
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters for the current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try each letter
        for (int i = 0; i < letters.length(); i++) {

            // Add one letter and move to the next digit
            backtrack(
                digits,
                index + 1,
                current + letters.charAt(i),
                phone,
                result
            );
        }
    }
}
