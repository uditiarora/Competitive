import java.util.*;
import java.io.*;



public class Main {
	public static long dfs(ArrayList<Integer> g[],int v, boolean vis[],int n,long[] dp){
		long ans=0;
		if(v==n){
			return 1;
		}
		if(vis[v]==true){
			return dp[v];
		}
		vis[v]=true;
		int x = g[v].size();
		for(int i=0;i<x;i++){
			ans += dfs(g,g[v].get(i),vis,n,dp);
		}
		dp[v] = ans;
		return ans
				;
	}
	public static void main(String[] args) throws IOException{
		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> g[] = new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			g[i] = new ArrayList<Integer>();
		}
		int a,b;
		while(true){
			a = s.nextInt();
			b = s.nextInt();
			if(a==0 && b==0){
				break;
			}
			g[a].add(b);
		}
		boolean vis[]  =new boolean[n+1];
		long dp[] = new long[n+1];
		System.out.println(dfs(g,1,vis,n,dp));
	}

}