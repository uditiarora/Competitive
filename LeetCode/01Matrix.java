class Solution {
    public int[][] updateMatrix(int[][] matrix) {
	int m = matrix.length ;
	int n = matrix[0].length;
	int[][] dp = new int[m][n];
	for(int i=m-1;i>=0;i--){
		for(int j=n-1;j>=0;j--){
			if(matrix[i][j] == 1){
				dp[i][j] = Math.min(getDp(dp, i+1, j,m,n), getDp(dp, i,j+1,m,n)) + 1;
			}
		}
	}
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if(matrix[i][j] == 1){
				int top = getDp(dp, i-1, j, m, n);
				int left = getDp(dp, i, j-1, m, n);
				int bottom = getDp(dp, i+1, j, m,n);
				int right = getDp(dp, i, j+1, m, n);
				dp[i][j] = 1 + Math.min(Math.min(top, left), Math.min(bottom, right));
			}
		}
	}
	return dp;
}

private int getDp(int[][] dp, int i,int j,final int m,final int n){
	if(i < 0 || j < 0 || i >= m || j >= n){
		return 99999;
	}
	return dp[i][j];
}
}