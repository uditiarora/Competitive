
import java.util.*;
import java.io.*;
public class Main {
	 static boolean arr[]=new boolean[10000];
	     public static void sieve()
	     {
	    	 for(int i=0;i<9000;i++){
	    	        arr[i]=true;
	    	      }
	    	      long count=0;
	    	      for(int i=2;i*i<9000;i++){
	    	        if(arr[i]==true){
	    	          
	    	          for(int j=2*i;j<9000;j=j+i){
	    	            arr[j]=false;
	    	          }
	    	        }
	    	      }
	     }
	public static void main(String[] args) throws IOException{
		// Write your code here
     sieve();
     int mod = (int)Math.pow(10, 9) +7;
      Scanner  s =new Scanner(System.in);
     int t=s.nextInt();
     while(t--!=0){
    	 
    	 int ans=0;
    	 int n =s.nextInt();
    	 int input[]=new int[n];
    	 int count[] = new int[1002];
    	 for(int i=0;i<n;i++){
    		 input[i] = s.nextInt();
    		 count[input[i]-3500]++;
    	 }
    		long dp[][] = new long[1002][8200];
    	 int flag=1;
    	 dp[0][0] = (count[0]+2)/2 ;
    	 dp[0][3500] = (count[0]+1)/2;
    	 for(int i=1;i<=1001;i++){
    		 for(int j=0;j<=8191;j++){
    			 int temp = count[i];
    			 dp[i][j] = (dp[i-1][j] * ((2+temp)/2) + dp[i-1][j^(i+3500)] * ((1+temp)/2))%mod;  
    		 }
    	 }
    	 
    	 for(int i=2;i<=8191;i++){
    		 if(arr[i]){
    			 ans = (int)(((long)ans+dp[1001][i])%mod);

    		 }
    	 }
    	System.out.println(ans);
     }
      
      

	}

}