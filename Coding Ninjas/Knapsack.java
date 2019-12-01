
public class Solution {
	
	
	
	public static int knapsack(int[] weight,int value[],int w){

	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
		int n = weight.length;
      int dp[][] = new int[w+1][n+1];
      for(int i=1;i<=w;i++){
        for(int j = 1;j<=n;j++){
          if(weight[j-1]>i){
            dp[i][j] = dp[i][j-1];
          }
          else{
            dp[i][j] = Math.max(dp[i-weight[j-1]][j-1]+value[j-1],dp[i][j-1]);
          }
        }
      }
      return dp[w][n];
	}
	
}
