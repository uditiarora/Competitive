import java.util.*;
import java.io.*;

public class Main {
	public static void update(ArrayList<Integer>[] g,int v,int dis[]){
		ArrayList<Integer> temp = g[v];
		int n = temp.size();
		for(int i=0;i<n;i++){
			int u = temp.get(i);
			if(dis[u]>dis[v]+1){
				dis[u] = dis[v]+1;
				update(g,u,dis);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		ArrayList<Integer> g[] = (ArrayList<Integer>[])new ArrayList[n+1];
		Arrays.fill(g, new ArrayList<Integer>());
		int dis[] = new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE-2);
		dis[1]=0;
		while(t--!=0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1){
				int x = Integer.parseInt(st.nextToken());
				if(dis[x]==Integer.MAX_VALUE-2){
                  System.out.println("-1");
				}
				else{
					System.out.println(dis[x]);
				}
			}
			else{
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				g[x].add(y);
				if(dis[y]>dis[x]+1){
					dis[y] = dis[x]+1;
					update(g,y,dis);
				}
			}
		}
			
		
	}

}