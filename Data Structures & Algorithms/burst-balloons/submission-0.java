class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Create a padded array with 1's at both ends
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        // dp[left][right] = max coins obtainable by bursting all balloons
        // strictly between indices left and right (exclusive)
        int[][] dp = new int[n + 2][n + 2];

        // len = size of the gap between left and right
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left + len <= n + 1; left++) {
                int right = left + len;

                // Try every balloon k as the LAST one burst in the (left, right) range
                for (int k = left + 1; k < right; k++) {
                    int coins = balloons[left] * balloons[k] * balloons[right]
                              + dp[left][k]
                              + dp[k][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n + 1];
    }
}