import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
	/*public static int util(int dp[][],boolean arr[],int o,int c,int n){
		if(o>n || c>n){
			return 0;
		}
		if(o==n && c==n){
			return dp[o][c]=1;
		}
		else if (o==c || arr[o+c]==true){
			if(dp[o+1][c]==0){
				dp[o+1][c]=util(dp,arr,o+1,c,n);
			}
			return dp[o][c] = dp[o+1][c];
			
		}
		else if(o==n){
			if(dp[o][c+1]==0){
				dp[o][c+1]=util(dp,arr,o,c+1,n);
			}
			return dp[o][c] = dp[o][c+1];
		}
		else{
			if(dp[o+1][c]==0){
				dp[o+1][c] = util(dp,arr,o+1,c,n);
			}
			if(dp[o][c+1]==0){
				dp[o][c+1] = util(dp,arr,o,c+1,n);
			}
			return dp[o][c] = dp[o+1][c] + dp[o][c+1];
		}
		
	}*/
	public static int util2(int dp[][],int o,int c,int cur,int k,int n,boolean arr[]){
		if(dp[o][cur]!=-1){
			return dp[o][cur];
		}
		if(o>n ||(o==n && k!=0)){
			if(arr[cur]==true){
				k--;
			}
			return 0;
		}
		if(o==n){
			if(arr[cur]==true){
				k--;
			}
			return 1;
		}
		if(arr[cur]==true){
			k--;
		}
		if(o==c || arr[cur]==true){
			return dp[o][cur] = util2(dp, o+1, c, cur+1, k, n, arr);
		}
		else if(o-c>0){
			return dp[o][cur] = util2(dp, o, c+1, cur+1, k, n, arr) + util2(dp, o+1, c, cur+1, k, n, arr);   
		}
		else return dp[o][cur]=0;
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t--!=0){
			int n = s.nextInt();
			int k = s.nextInt();
			boolean arr[]= new boolean[n*2 +1];
			int p=0;
			for(int i=0;i<k;i++){
				int temp = s.nextInt();
				if(arr[temp]==false){
					p++;
				}
				arr[temp]=true;
			}
			if(arr[2*n]==true){
				System.out.println("0");
				continue;
			}
			int dp[][] = new int[21][41];
			for(int i=0;i<21;i++){
				Arrays.fill(dp[i], -1);
			}
			System.out.println(util2(dp,0,0,1,p,n,arr));
			
		}
      
	}
}

