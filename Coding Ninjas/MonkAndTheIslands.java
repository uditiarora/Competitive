import java.util.*;
import java.io.*;
public class Main {
static int ans=1;
	public static int bfs(int v,int n,ArrayList<Integer> g[]){
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(1);
      int level[] = new int[n+1];
      //q.add(-1);
      boolean vis[] = new boolean[n+1];
      vis[1]=true;
      int x=0;
      while(x!=n){
         x = q.poll();
        
        for(int i=0;i<g[x].size();i++){
          int temp = g[x].get(i);
          if(vis[temp]==false){
            vis[temp]=true;
            q.add(temp);
            level[temp] = level[x]+1;
          }
        }
      }
      return level[n];
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
        ArrayList<Integer>[] g = new ArrayList[n+1];
        Arrays.fill(g,new ArrayList<Integer>());
        for(int i=0;i<m;i++){
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          g[x].add(y);
          g[y].add(x);
            
        }
        ans=1;
       
        System.out.println((bfs(1,n,g)+1));
      }
	}

}