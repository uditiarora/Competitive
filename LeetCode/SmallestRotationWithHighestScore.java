class Solution {
    public int bestRotation(int[] A) {
        int n = A.length;
        int dp[] = new int[n+1];
        for(int i=0;i<n;i++){
            if(A[i]<=i){
                dp[0]++;
                dp[i-A[i]+1]--;
                dp[i+1]++;
                dp[n]--;
                
            }
            else{
                dp[i+1]++;
                dp[n+i-A[i]+1]--;
                
            }
            
        }
        int ans = 0;
        int max = 0;
        int c = 0;
        for(int i=0;i<n;i++){
            c += dp[i];
            if(c>max){
                max = c;
                ans = i;
            }
        }
        return ans;
    }
}