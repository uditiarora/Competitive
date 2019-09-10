class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        if(r==0){
            return 0;
        }
        int c = matrix[0].length;
        
        int dp[][] = new int[r][c];
        int max = 1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                max = Math.max(max,util(i,j,matrix,dp,-1,r,c));
            }
        }
        return max;
    }
    
    public int util(int i,int j,int matrix[][], int dp[][], int last,int r, int c){
        if(i>=r || i<0 || j>=c || j<0){
            return 0;
        }
        
        if(last>=matrix[i][j]){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int ans = 1;
        ans = Math.max(ans, util(i+1,j,matrix,dp,matrix[i][j],r,c)+1);
        ans = Math.max(ans, util(i-1,j,matrix,dp,matrix[i][j],r,c)+1);
        ans = Math.max(ans, util(i,j+1,matrix,dp,matrix[i][j],r,c)+1);
        ans = Math.max(ans, util(i,j-1,matrix,dp,matrix[i][j],r,c)+1);
        dp[i][j] = ans;
        return ans;
    }
    
}