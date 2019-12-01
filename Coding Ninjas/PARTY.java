import java.util.*;
import java.io.*;
public class Main {


		
	public static void main(String[] args) throws IOException{
		// Write your code here
     
      Scanner  s =new Scanner(System.in);
      while(true){
        
        int w = s.nextInt();
        int n = s.nextInt();
        if(w==0 && n==0){
          break;
        }
        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++){
          
        weight[i] = s.nextInt();
        value[i] = s.nextInt();
        }
        //System.out.println(knapsack(wt,val,W));
        int index=0,max=0;
        int dp[][] = new int[n+1][w+1];
	      for(int i=0;i<=n;i++){
	        for(int j=0;j<=w;j++){
	          if(i==0 || j==0){
	            dp[i][j]=0;
	            
	          }
	         else if(weight[i-1] <= j){
	           dp[i][j] = Math.max(dp[i-1][j-weight[i-1]] + value[i-1] , dp[i-1][j]);
              
	         }
	          else{
	            dp[i][j] = dp[i-1][j];
	          }
	        }
	      }
        max = dp[n][w];
        for(int i=0;i<=w;i++){
          if(dp[n][i] == max){
            index=i;
            break;
          }
        }
        System.out.println(index+" "+max);
      }
     
      
      
      

	}

}