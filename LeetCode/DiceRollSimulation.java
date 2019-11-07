class Solution {
    static int dp[][][] = new int[5001][6][16];
    static int mod = (int)Math.pow(10,9)+7;
    public int dieSimulator(int n, int[] rollMax) {
        for(int i=0;i<=5000;i++){
            for(int j=0;j<6;j++){
                for(int k=0;k<16;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return util(n,0,0,rollMax);
    }
    
    public int util(int n, int d, int k, int[] roll){
        if(n == 0){
            if(roll[d]<k){
                return 0;
            }
            else{
                return 1;
            }
        }
        if(roll[d]<k){
            return 0;
        }
        if(dp[n][d][k]>=0){
            return dp[n][d][k];
        }
        long ans = 0;
        for(int i=0;i<6;i++){
            ans += util(n-1,i,i==d?k+1:1,roll);
        }
        ans = ans%mod;
        dp[n][d][k] = (int)ans;
        return dp[n][d][k];
        
        
    }
}