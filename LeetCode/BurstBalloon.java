class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        
        int dp[][] = new int[n+2][n+2];
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        n += 2;
        for(int l = 3;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j = i+l-1;
                for(int k = i+1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i]*arr[j]*arr[k]);
                }
            }
        }
        return dp[0][n-1];
    }
}