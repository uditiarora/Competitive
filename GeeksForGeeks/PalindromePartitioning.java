/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t--!=0){
		    String str = s.next();
		    int n = str.length();
		    int dp[][] = new int[n+1][n+1];
		    boolean pal[][] = new boolean[n+1][n+1];
		    for(int i=0;i<=n;i++){
		        dp[i][i] = 0;
		        pal[i][i] = true;
		    }
		    
		    for(int l=2;l<=n;l++){
		        for(int i=0;i<n-l+1;i++){
		            int j = i+l-1;
		            if(l==2){
		                pal[i][j] = (str.charAt(i) == str.charAt(j) );
		            }
		            else{
		                pal[i][j] = ((str.charAt(i) == str.charAt(j)) && pal[i+1][j-1]);
		            }
		            
		            if(pal[i][j] == true){
		                dp[i][j] = 0;
		            }
		            else{
		                dp[i][j] = Integer.MAX_VALUE;
		                for(int k=i;k<j;k++){
		                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+1+dp[k+1][j]);
		                }
		            }
		        }
		    }
		    System.out.println(dp[0][n-1]);
		    
		}
	}
}