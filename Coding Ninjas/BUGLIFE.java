import java.util.*;
import java.io.*;



public class Main {
	
	public static boolean dfs(ArrayList<Integer> g[], int v,boolean vis[],int col[]){
		if(vis[v]==true){
			return true;
		}
		boolean ans = true;
		vis[v] = true;
		int n = g[v].size();
		for(int i=0;i<n;i++){
			int x = g[v].get(i);
			if(col[x]==col[v]){
				return false;
			}
			else{
				col[x] = 1-col[v];
				ans = dfs(g,x,vis,col);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int k=1;k<=t;k++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<Integer> g[] = new ArrayList[n+1];
			for(int i=0;i<=n;i++){
				g[i] = new ArrayList<Integer>();
			}
			int a,b;
			for(int i=0;i<m;i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				g[a].add(b);
				g[b].add(a);
			}
			boolean vis[] = new boolean[n+1];
			boolean ans = true;
			int col[] = new int[n+1];
			Arrays.fill(col, -1);
			for(int i=1;i<=n;i++){
				if(vis[i]==false){
					col[i]=0;
					ans = dfs(g,i,vis,col);
					if(ans==false){
						break;
					}
				}
			}
			if(ans==true){
				System.out.println("Scenario #"+k+":");
              System.out.println("No suspicious bugs found!");
			}
			else{
				System.out.println("Scenario #"+k+":");
              System.out.println("Suspicious bugs found!");

			}
		}
	}

}