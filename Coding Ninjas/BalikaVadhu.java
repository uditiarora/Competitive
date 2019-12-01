import java.util.Arrays;
import java.util.Scanner;

public class Main {

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
	public static void main(String[] args) {
		// Write your code here
		
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t--!=0){
        String s1 = s.next();
        String s2 = s.next();
        int k = s.nextInt();
        int m = s1.length();
        int n = s2.length();
        if(lcs(s1,s2) < k){
          System.out.println("0");
          continue;
        }
        int dp[][][] = new int[m+1][n+1][k+1];
        for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
            for(int z=1;z<=k;z++){
              int ans1 =0 ,ans2=0,ans3=0;
              if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans1 = s1.charAt(i-1) + dp[i-1][j-1][z-1];
              }
              ans2 = dp[i-1][j][z] ;
              ans3 = dp[i][j-1][z];
              dp[i][j][z] = Math.max(ans1,Math.max(ans2,ans3));
            }
          }
        }
        System.out.println(dp[m][n][k]);
      }
      
      
      
	}

}