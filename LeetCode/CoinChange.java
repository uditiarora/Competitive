class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        for(int i=0;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(coins[j]<=i && dp[i-coins[j]] !=Integer.MAX_VALUE ){
                    dp[i] = Math.min(dp[i-coins[j]] + 1, dp[i]);
                }
            }
        }
        if(dp[amount] != Integer.MAX_VALUE){
            return dp[amount];
        }
        return -1;
        
        
    }
}