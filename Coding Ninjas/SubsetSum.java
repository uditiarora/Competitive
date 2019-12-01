
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s =new Scanner(System.in);
		int n =s.nextInt();
      int[] arr=new int[n];
      for(int i=0;i<n;i++){
        arr[i]=s.nextInt();
      }
      int k = s.nextInt();
      boolean dp[][] = new boolean[k+1][n+1];
      //dp[0] = true;
      for(int i=0;i<=n;i++){
        dp[0][i]=true;
      }
      for(int i=1;i<=k;i++){
        for(int j=1;j<=n;j++){
          dp[i][j] = dp[i][j-1];
          if(arr[j-1] <= i){
            dp[i][j] = dp[i][j] || dp[i-arr[j-1]][j-1];
          }
        }
      }
      if(dp[k][n]){
        System.out.println("Yes");
      }
      else{
        System.out.println("No");
      }
	}

}