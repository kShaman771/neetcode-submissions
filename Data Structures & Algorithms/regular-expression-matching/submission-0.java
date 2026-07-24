class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] = true if s[0..i) matches p[0..j)
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c* that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // '*' applies to the character before it: p.charAt(j - 2)
                    char prevPatternChar = p.charAt(j - 2);

                    // Option 1: treat "x*" as matching zero occurrences — skip both
                    dp[i][j] = dp[i][j - 2];

                    // Option 2: if the preceding pattern char matches current s char,
                    // we can "use" one occurrence of it and stay on the same pattern position
                    if (prevPatternChar == '.' || prevPatternChar == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == sc) {
                    // Direct character match (or '.' wildcard)
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // else: dp[i][j] stays false (mismatch)
            }
        }

        return dp[m][n];
    }
}