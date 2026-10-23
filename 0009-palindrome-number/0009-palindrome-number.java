
class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        int original = x;
        int reverse = 0;

        // Reverse the number
        while (x > 0) {
            int digit = x % 10;           // Get last digit
            reverse = reverse * 10 + digit; // Add digit to reverse
            x = x / 10;                   // Remove last digit
        }

        // Check if original and reversed numbers are equal
        return original == reverse;
    }
}
