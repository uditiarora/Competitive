class Solution {
    public int numTilings(int N) {
        final int mod = 1000000007;
        int[][] dp = new int[N + 1][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][2] = dp[i - 2][0];
            dp[i][1] = (dp[i - 1][1] + dp[i - 2][0]) % mod;
            dp[i][0] = ((dp[i][2] + dp[i - 1][0]) % mod + (dp[i - 1][1] * 2) % mod) % mod;
        }
        return dp[N][0];
    }
}