
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] means first i characters of s
        // match the first j characters of p
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches an empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Check each character of string and pattern
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // Normal character or dot matches
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // Star matches zero or more occurrences
                else if (pc == '*') {
                    // Ignore the preceding character and *
                    dp[i][j] = dp[i][j - 2];

                    // If preceding pattern character matches,
                    // use * to match one more character
                    char prev = p.charAt(j - 2);

                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        // Entire string must match the entire pattern
        return dp[m][n];
    }
}
