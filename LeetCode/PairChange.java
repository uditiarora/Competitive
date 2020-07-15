class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a,b) -> a[0] - b[0] );
        int dp[] = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = 1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(pairs[i][1]<pairs[j][0]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(dp[i],res);
        }
        return res;
    }
}