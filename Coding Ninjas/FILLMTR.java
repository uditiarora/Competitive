import java.util.*;
import java.io.*;

class pair2{
	int v;
	int w;
	public pair2(int v,int w){
		this.v = v;
		this.w = w;
	}
}

public class Main {
	
	
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t--!=0){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			ArrayList<pair2> g[] = new ArrayList[n+1];
			for(int i=0;i<=n;i++){
				g[i] = new ArrayList<pair2>();
			}
			int a,b,c;
			for(int i=0;i<q;i++){
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				g[a].add(new pair2(b,c));
				g[b].add(new pair2(a,c));
			}
			boolean vis[] = new boolean[n+1];
			int col[] = new int[n+1];
			boolean ans = true;
			for(int i=1;i<=n;i++){
				if(vis[i]==false){
					vis[i] = true;
					Queue<Integer> bfs = new LinkedList<Integer>();
					bfs.add(i);
					while(!bfs.isEmpty()){
						int temp = bfs.poll();
						int len = g[temp].size();
						for(int j=0;j<len;j++){
							pair2 temp2 = g[temp].get(j);
							if(vis[temp2.v]==false){
								bfs.add(temp2.v);
								vis[temp2.v] = true;
								if(temp2.w==0){
									col[temp2.v] = col[temp];
								}
								else{
									col[temp2.v] = 1-col[temp];
								}
							}
							else{
								if(temp2.w==0 && col[temp]!=col[temp2.v]){
									ans=false;
								}
								if(temp2.w==1 && col[temp]==col[temp2.v]){
									ans=false;
								}
								
								
							}
						}
					}
				}
			}
			if(ans==true){
				System.out.println("yes");
			}
			else{
				System.out.println("no");
			}
			
		}
	}

}