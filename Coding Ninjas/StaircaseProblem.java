
public class Solution {
	
		
public static long staircase(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
		long dp[]= new long[n+1];
  	dp[0]=1;
  
  for(int i=1;i<=n;i++){
    for(int j=1;j<=3 && j<=i;j++){
      dp[i] = dp[i]+dp[i-j];
    }
  }
  return dp[n];
	}
	
}
