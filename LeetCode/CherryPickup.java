class Solution {
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][] = new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k] = -2;
                }
            }
        }
        return Math.max(0, util(0,0,0,dp,grid,n));
    }
    public int util(int x1, int y1, int x2, int dp[][][], int grid[][],int n){
        int y2 = x1+y1-x2;
        if(x1>=n || x2>=n || y1>=n || y2>=n || grid[x1][y1]==-1 || grid[x2][y2]==-1){
            return Integer.MIN_VALUE;
        }
        else if(x1==n-1 && y1==n-1){
            return grid[x1][y1];
        }
        else if(dp[x1][y1][x2] != -2){
            return dp[x1][y1][x2];
        }
        else{
            int temp = grid[x1][y1];
            temp += Math.max(Math.max(dp[x1+1][y1][x2],dp[x1][y1+1][x2]),Math.max(dp[x1+1][y1][x2+1],dp[x1][y1+1][x2+1]));
            dp[x1][y1][x2] = temp;
            return temp;
        }
    }
}