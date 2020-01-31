import java.util.*;
import java.io.*;



public class Main {
	public static ArrayList<ArrayList<Integer>> util(ArrayList<Integer> g[]){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int n = g.length;
		
		boolean vis[] = new boolean[n+1];
		for(int i=0;i<n;i++){
			if(vis[i]==false){
				ArrayList<Integer> temp = new ArrayList<Integer>();

				dfs(g,i,temp,vis);
				ans.add(temp);
			}
		}
		return ans;
	}
	
	public static void dfs(ArrayList<Integer> g[], int v,ArrayList<Integer> temp, boolean vis[]){
		if(vis[v]==true){
			return;
		}
		temp.add(v);
		vis[v] = true;
		int n = g[v].size();
		for(int i=0;i<n;i++){
			dfs(g, g[v].get(i), temp, vis);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t--!=0){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int p[] = new int[n+1];
			int q[] = new int[n+1];
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> g[] = new ArrayList[n+1];
			for(int i=0;i<n;i++){
				p[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<=n;i++){
				g[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++){
				q[i] = Integer.parseInt(st.nextToken());
			}
			int a,b;
			for(int i=0;i<m;i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				g[a-1].add(b-1);
				g[b-1].add(a-1);
			}
			
			ArrayList<ArrayList<Integer>> result = util(g);
			
			boolean r = false;
			for (int i = 0; i < result.size(); i++) {
				ArrayList<Integer> c = result.get(i);
				boolean bool = false;
				HashMap<Integer,Integer> a1 = new HashMap();
				for (int j = 0; j < c.size(); j++) {
					a1.put(p[c.get(j)],1);
				}
				for(int j=0;j<c.size();j++) {
					if(!a1.containsKey(q[c.get(j)])) {
						System.out.println("NO");
						r=true;
                      	break;
					}
				}
				if(r) {
					break;
				}
			}
			if (!r) {
				System.out.println("YES");
			} 
			
			
		}
	}

}