
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // If the character is repeated, remove characters
            // from the left until the duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(s.charAt(right));

            // Calculate the length of the current window
            int length = right - left + 1;

            // Update the maximum length
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
