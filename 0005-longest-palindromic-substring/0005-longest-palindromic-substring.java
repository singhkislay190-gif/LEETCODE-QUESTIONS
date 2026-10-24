
class Solution {
    public String longestPalindrome(String s) {

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            // Case 1: Odd length palindrome (example: bab)
            int len1 = expand(s, i, i);

            // Case 2: Even length palindrome (example: bb)
            int len2 = expand(s, i, i + 1);

            // Find the longer palindrome
            int len = Math.max(len1, len2);

            // Update starting position and maximum length
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    // Expand outwards while characters match
    private int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // Calculate palindrome length
        return right - left - 1;
    }
}
