import java.util.*;
import java.io.*;

public class Main {
	static int time=0;
	public static void dfs(ArrayList<Integer>[] g,int[] in,int[] out,boolean vis[],int v){
		if(vis[v]==true){
			return;
		}
		//System.out.println(v);
		vis[v] = true;
		in[v] = ++time;
		ArrayList<Integer> temp = g[v];
		int n = temp.size();
		for(int i=0;i<n;i++){
			
				dfs(g, in, out, vis, temp.get(i));
			
		}
		out[v] = ++time;
		
	}
	
	public static boolean check(int x,int y,int[] in,int out[]){
		if(in[y]>in[x] && out[y]<out[x]){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> g[] = new ArrayList[n+1];
		Arrays.fill(g, new ArrayList<Integer>());
		int x,y;
		for(int i=0;i<n-1;i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			ArrayList<Integer> temp = g[y];
			temp.add(x);
			g[y] = temp;
			
		}
		int q = Integer.parseInt(br.readLine());
		int in[] = new int[n+1];
		int out[] = new int[n+1];
		boolean vis[] = new boolean[n+1];
		
		dfs(g,in,out,vis,1);
		
		/*for(int i=0;i<=n;i++){
			for(int j=0;j<g[i].size();j++){
				System.out.print(g[i].get(j)+" ");
			}
			System.out.println();
		}*/
		
		
		/*for(int i=1;i<=n;i++){
			System.out.print(in[i]+" ");
		}
		System.out.println();
		for(int i=1;i<=n;i++){
			System.out.print(out[i]+" ");
		}*/
		while(q--!=0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(check(b,c,in,out)==false && check(c,b,in,out)==false){
				System.out.println("NO");
				//System.out.println("hi");
			}
			else if(check(b,c,in,out)==true && a==0){
				System.out.println("YES");
			}
			else if(check(c,b,in,out)==true && a==1){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		
	}

}