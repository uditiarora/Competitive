import java.util.*;
import java.io.*;



public class Main {
	
	public static void dfs1(ArrayList<Integer> g[],int v,Stack<Integer> s,boolean vis[]){
		if(vis[v]==true){
			return;
		}
		int n = g[v].size();
		vis[v] = true;
		for(int i=0;i<n;i++){
			dfs1(g,g[v].get(i),s,vis);
		}
		s.push(v);
	}
	public static void dfs2(ArrayList<Integer> gr[],int v, int scc[],boolean visr[],int num){
		if(visr[v]==true){
			return;
		}
		visr[v] = true;
		scc[v] = num;
		int n = gr[v].size();
		for(int i=0;i<n;i++){
			dfs2(gr,gr[v].get(i),scc,visr,num);
		}
	}
	public static int sccs(ArrayList<Integer> g[],ArrayList<Integer> gr[],int scc[],int n){
		Stack<Integer> s = new Stack<Integer>();
		boolean vis[] = new boolean[n+1];
		boolean visr[] = new boolean[n+1];
		for(int i=1;i<=n;i++){
			if(vis[i]==false){
				dfs1(g,i,s,vis);
			}
		}
		int num=1;
		while(!s.isEmpty()){
			int x = s.pop();
			if(visr[x] == false){
				dfs2(gr,x,scc,visr,num);
				num++;
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0){
				break;
			}
			int q = Integer.parseInt(st.nextToken());
			ArrayList<Integer> g[] = new ArrayList[n+1];
			ArrayList<Integer> gr[] = new ArrayList[n+1];
			st = new StringTokenizer(br.readLine());
			int a,b;
			for(int i=0;i<=n;i++){
				g[i] = new ArrayList<Integer>();
				gr[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<q;i++){
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				g[a].add(b);
				gr[b].add(a);
			}
			int scc[] = new int[n+1];
			int num = sccs(g, gr, scc, n);
			/*for(int i=0;i<=n;i++){
				System.out.println(scc[i]);
			}*/
			ArrayList<Integer> dac[] = new ArrayList[num];
			for(int i=0;i<num;i++){
				dac[i] = new ArrayList<Integer>();
			}
			int k;
			for(int i=1;i<=n;i++){
				int t = g[i].size();
				for(int j=0;j<t;j++){
					k = g[i].get(j);
					if(scc[i]!=scc[k]){
						dac[scc[i]].add(scc[k]);
					}
				}
			}
			/*for(int i=1;i<num;i++){
				int t = dac[i].size();
				for(int j=0;j<t;j++)
					System.out.println(i + " "+ dac[i].get(j));
			}*/
			
			boolean nsink[] = new boolean[num];
			for(int i=1;i<num;i++){
				int t = dac[i].size();
				if(t>0){
					nsink[i] = true;
				}
			}
			boolean ans[] = new boolean[n+1];
			for(int i=1;i<num;i++){
				if(nsink[i]==false){
					for(int j=1;j<=n;j++){
						if(scc[j]==i){
							ans[j]=true;
						}
					}
				}
			}
			for(int i=1;i<=n;i++){
				if(ans[i]==true){
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}

}