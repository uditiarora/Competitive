class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m+1][n+1];
        
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(j==0) dp[i][j] = false;
                else if(i==0){
                    dp[i][j] = p.charAt(j-1)=='*'?dp[i][j-1]:dp[i][j];
                }
                else{
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
                    else if(p.charAt(j-1) == '*'){
                        dp[i][j] = dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
    
}