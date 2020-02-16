import java.util.*;
import java.io.*;



public class Main {
	public static void bfs1(ArrayList<Integer> g[],boolean vis1[],int v){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		vis1[v]=true;
		int x,n ;
		while(!q.isEmpty()){
			x = q.poll();
			n = g[x].size();
			for(int i=0;i<n;i++){
				if(vis1[g[x].get(i)]==false){
					q.add(g[x].get(i));
					vis1[g[x].get(i)] = true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> g1[] = new ArrayList[n+1];
		ArrayList<Integer> g2[] = new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			g1[i] = new ArrayList<Integer>();
			g2[i] = new ArrayList<Integer>();
		}
		boolean vis1[] = new boolean[n+1];
		boolean vis2[] = new boolean[n+1];
		int a,b;
		for(int i=0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			g1[a].add(b);
			g2[b].add(a);
		}
		for(int i=1;i<=n;i++){
			boolean check = true;
			if(vis2[i]==false){
				bfs1(g2,vis1,i);
				for(int j=1;j<=n;j++){
					if(vis1[j]==false){
						check = false;
						break;
					}
				}
				if(check==true){
					vis2[i] = true;
					Arrays.fill(vis1, false);
					/*bfs1(g1,vis1,i);
					for(int j=1;j<=n;j++){
						if(vis1[j]==true){
							vis2[j]=true;
						}
					}*/
				}
			}
		}
		int ans=0;
		for(int i=1;i<=n;i++){
			if(vis2[i]==true){
				ans++;
			}
		}
		System.out.println(ans);
		for(int i=1;i<=n;i++){
			if(vis2[i]==true){
				System.out.print(i+" ");
			}
		}
	}

}