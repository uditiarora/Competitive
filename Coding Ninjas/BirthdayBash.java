import java.util.*;
import java.io.*;


class pair2{
	int val;
	int w;
	public pair2(int val,int w){
		this.val=val;
		this.w=w;
	}
}

public class Main {
	static int mod = (int)Math.pow(10, 9) + 7;
	static long ans=0;
	public static long dfs(ArrayList<pair2> g[], int v,int par,boolean vis[]){
		long curr = 1;
		
		vis[v]=true;
		int n = g[v].size();
		for(int i=0;i<n;i++){
			int u = g[v].get(i).val;
			int w = g[v].get(i).w;
			if(u!=par){
				long temp = dfs(g,u,v,vis);
				ans += (((temp*w)%mod)*(curr%mod))%mod;
				if(ans>=mod){
					ans = ans%mod;
				}
				curr += (temp*w);
				if(curr>=mod){
					curr = curr%mod;
				}
			}
			
		}
		return curr;
	}
	public static void main(String[] args) throws IOException{
		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<pair2> g[] = new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			g[i] = new ArrayList<pair2>();
		}
		int x,y,w;
		for(int i=0;i<n-1;i++){
			x = s.nextInt();
			y = s.nextInt();
			w = s.nextInt();
			g[x].add(new pair2(y,w));
			g[y].add(new pair2(x,w));
		}
		/*for(int i=1;i<=n;i++){
			int l = g[i].size();
			for(int j=0;j<l;j++){
				System.out.print(g[i].get(j).val+" ");
			}
			System.out.println();
		}*/
		boolean vis[] = new boolean[n+1];
		System.out.println(dfs(g,1,-1,vis));
		
	}

}