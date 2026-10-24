
class Solution {
    public String convert(String s, int numRows) {

        // If only one row, no zigzag is needed
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        int direction = 1;  // 1 = down, -1 = up

        // Traverse each character of the string
        for (char ch : s.toCharArray()) {

            // Add character to the current row
            rows[currentRow].append(ch);

            // Change direction at the top or bottom
            if (currentRow == 0) {
                direction = 1;
            } else if (currentRow == numRows - 1) {
                direction = -1;
            }

            // Move to the next row
            currentRow += direction;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
