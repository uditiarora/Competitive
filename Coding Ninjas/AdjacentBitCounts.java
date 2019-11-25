import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      int mod = (int)Math.pow(10,9)+7;
      while(t--!=0){
        int a = s.nextInt();
        int n = s.nextInt();
        int k= s.nextInt();
        int dp[][][]=new int[n+1][k+1][2];
        dp[1][0][0]=1;
        dp[1][0][1]=1;
       
        for(int i=2;i<=n;i++){
          for(int j=0;j<=k;j++){
           		dp[i][j][0]= (int)(((long)dp[i-1][j][0]+dp[i-1][j][1])%mod);
                    if(j>0)
                        dp[i][j][1]=dp[i-1][j-1][1];
                    dp[i][j][1]= (int)(((long)dp[i][j][1]+dp[i-1][j][0])%mod);
          }
        }
        
        int ans = (int)(((long)dp[n][k][0] + dp[n][k][1])%mod);
        System.out.println(a+" "+ans);
      }
		
	}

}