
public class Solution {

	
	public static int lcs(String s1, String s2){
		
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	*/
      
      
      int m = s1.length();
      int n = s2.length();
      int dp[][] = new int[m+1][n+1];
      for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
          if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] = 1+dp[i-1][j-1];
          }
          else{
            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
          }
        }
      }
      return dp[m][n];
      

	}

	
}
