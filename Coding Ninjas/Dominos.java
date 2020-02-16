import java.util.*;
import java.io.*;
public class Main {

	static LinkedList<Integer>[] g1 = new LinkedList[100002];
  //static LinkedList<Integer>[] g2 = new LinkedList[100002];
  static int ans=0;
  
  public static void dfs2(int v,boolean visi[]){
    visi[v]=true;
    for(int i=0;i<g1[v].size();i++){
      int temp = g1[v].get(i);
      if(visi[temp]==false){
        dfs2(temp,visi);
      }
    }
  }
  
  public static void dfs1(int v,boolean visi[],Stack<Integer> stack){
    visi[v] = true;
    for(int i=0;i<g1[v].size();i++){
      int temp = g1[v].get(i);
      if(visi[temp]==false){
        dfs1(temp,visi,stack);
      }
    }
    stack.push(v);
  }
	public static void main(String[] args) throws IOException{
		// Write your code here
		//Scanner s = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st ;
      
      int t = Integer.parseInt(br.readLine());
      while(t-- != 0){
        Stack<Integer> stack = new Stack<Integer>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Arrays.fill(g1,new LinkedList<Integer>());
       // Arrays.fill(g2,new LinkedList<Integer>());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          g1[a].add(b);
         // g2[b].add(a);
          
        }
        ans=0;
        boolean visi[] = new boolean[n+1];
        for(int i=1;i<=n;i++){
          if(visi[i]==false){
            dfs1(i,visi,stack);
            
          }
        }
        Arrays.fill(visi,false);
       while(!stack.isEmpty()){
         int temp = stack.pop();
         if(!visi[temp]){
           dfs2(temp,visi);
           ans++;
         }
       }
        System.out.println(ans);
      }
      
	}

}