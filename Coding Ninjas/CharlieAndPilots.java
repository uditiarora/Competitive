import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
		    
	public static void main(String[] args) throws IOException{
		// Write your code here
      Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
      int n = s.nextInt();
      int[] cap = new int[n];
      int[] assi = new int[n];
      for(int i=0;i<n;i++){
    	  cap[i] = s.nextInt();
    	  assi[i] = s.nextInt();
      }
      int dp[][] = new int[n][n/2+1];
      dp[0][0] = assi[0];
     
      for(int j=0;j<=n/2;j++){
    	  dp[n-1][j] = cap[n-1];
      }
      for(int i= n-2 ;i>=0;i--){
    	  for(int j=0;j<=n/2;j++){
    		  if(j==0){
    			  dp[i][j] = dp[i+1][j+1] + assi[i];
    		  }
    		  else if(j== n-i || j == n/2){
    			  dp[i][j] = cap[i] + dp[i+1][j-1];
    		  }
    		  else{
    			  dp[i][j] = Math.min(assi[i] + dp[i+1][j+1], cap[i] + dp[i+1][j-1]);
    		  }
    		 
    	  }
      }
     
      System.out.println(dp[0][0]);
      
	}
}

