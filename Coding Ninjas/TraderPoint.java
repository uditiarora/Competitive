import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
	public static int util(int dp[][][],int arr[],int index,int n,int k,int flag){
		if(n<=0){
			return 0;
		}
		if(dp[n][k][flag]!=0){
			return dp[n][k][flag];
		}
		int temp = util(dp,arr,index+1,n-1,k,flag);
		if(flag==1){
			return dp[n][k][flag] = Math.max(temp, util(dp,arr,index+1,n-1,k-1,0)+arr[index]);
			
		}
		else{
			if(k>0){
				return dp[n][k][flag]=Math.max(temp,util(dp,arr,index+1,n-1,k,1)-arr[index]);
			}
			else{
				return dp[n][k][flag] = temp; 
			}
		}
		
		
		
	}
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   int t = Integer.parseInt(br.readLine());
	   while(t--!=0){
		   int k = Integer.parseInt(br.readLine());
		   int n = Integer.parseInt(br.readLine());
		   int arr[]=new int[n];
		   st = new StringTokenizer(br.readLine());
		   for(int i=0;i<n;i++){
			   arr[i] = Integer.parseInt(st.nextToken());
		   }
		   int dp[][][] = new int[n+1][k+1][2];
		   System.out.println(util(dp,arr,0,n,k,0));
	   }
				
	}
}

