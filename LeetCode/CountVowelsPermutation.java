class Solution {
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n][5]; 
        int m = (int)Math.pow(10,9)+7;
        for(int i=0; i<n; i++) {
            if(i == 0) {
                dp[i][0] = dp[i][1] = dp[i][2] = dp[i][3] = dp[i][4] = 1; 
            } else {
                dp[i][0] = dp[i-1][1]%m; 
                dp[i][1] = (dp[i-1][0] + dp[i-1][2])%m;
                dp[i][2] = (((dp[i-1][0] + dp[i-1][1])%m + dp[i-1][3])%m + dp[i-1][4])%m; 
                dp[i][3] = (dp[i-1][2] + dp[i-1][4])%m; 
                dp[i][4] = dp[i-1][0]%m; 
            }
        }
        return ((((dp[n-1][0] + dp[n-1][1])%m+ dp[n-1][2])%m + dp[n-1][3])%m + dp[n-1][4])%m; 
    }
}
