import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      while(t--!=0){
        int m =s.nextInt();
        int n =s.nextInt();
        int arr[][] = new int[m][n];
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
            arr[i][j]=s.nextInt();
          }
        }
        
        
        for(int i=0;i<=m;i++){
          dp[i][n]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
          dp[m][i]=Integer.MAX_VALUE;
        }
        dp[m-1][n-1]=0-arr[m-1][n-1];
        dp[m][n-1]=1;
        dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
          for(int j=n-1;j>=0;j--){
          	
            dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])-arr[i][j];
            if(dp[i][j]<=0){
            	dp[i][j]=1;
            }
            
            
            //System.out.print(dp[i][j]+" ");
          }
          //System.out.println();
        }
        //dp[0][0]++;
        if(dp[0][0]<=0){
          dp[0][0]=1;
        }
       	System.out.println(dp[0][0]);
      }
	}

}