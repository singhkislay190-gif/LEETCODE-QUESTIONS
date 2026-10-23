
class Solution {
    public int romanToInt(String s) {

        int total = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = value(s.charAt(i));

            // If current symbol is smaller than the next one,
            // subtract its value
            if (i + 1 < s.length() &&
                current < value(s.charAt(i + 1))) {
                total = total - current;
            } else {
                // Otherwise, add its value
                total = total + current;
            }
        }

        return total;
    }

    // Convert Roman symbol into its integer value
    public int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }
}
