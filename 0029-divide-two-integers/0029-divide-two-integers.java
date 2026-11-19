
class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow condition
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Find the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to long and make them positive
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        // Subtract the largest possible multiple of divisor
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double divisor using left shift
            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            // Subtract and update quotient
            a = a - temp;
            result = result + multiple;
        }

        // Apply the sign
        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}
