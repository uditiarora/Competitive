import java.util.*;
class pair{
	int a,b;
	public pair(int a,int b) {
		// TODO Auto-generated constructor stub
		this.a=a;
		this.b=b;
	}
}
public class Main {
  
  static int sum=0;
  static int dirc[][] = new int[][]{ {2 , 1}, {2 , -1}, {-2 , 1}, {-2, -1}, {1 , 2}, {1 , -2}, {-1, 2}, {-1, -2} };
  public static void dfs(int x,int y,boolean[][] graph,boolean[][] visi,int n,int m){

    Queue<pair> q = new LinkedList<pair>();
    q.add(new pair(x,y));
    visi[x][y]=true;
    while(!q.isEmpty()){
    	pair temp = q.poll();
    	sum++;
    	for(int i=0;i<8;i++){
    		int x1 = temp.a + dirc[i][0];
    		int y1 = temp.b + dirc[i][1];
    		if(x1>0 && y1>0 && x1<=n && y1<=m && graph[x1][y1] && !visi[x1][y1]){
    			q.add(new pair(x1,y1));
              visi[x1][y1] = true;
    		}
    	}
    }
  }
  
  
	static int[] fact = new int[1000001];
	static int mod = (int)Math.pow(10,9) + 7;
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      fact[0]=1;
      fact[1]=1;
      for(int i=2;i<=1000000;i++){
        fact[i] = (int)(((long)fact[i-1]*i)%mod);
      }
      int t = s.nextInt();
      while(t-- != 0){
        int res = 1;
        int n = s.nextInt();
        int m = s.nextInt();
        int q = s.nextInt();
        boolean graph[][] = new boolean[1010][1010];
        boolean visi[][] = new boolean[1010][1010];
        for(int i=0;i<q;i++){
          int x = s.nextInt();
          int y = s.nextInt();
          graph[x][y] = true;
        }
        for(int i=1;i<=n;i++){
          for(int j=1;j<=m;j++){
            if(graph[i][j] && !visi[i][j]){
              sum=0;
              dfs(i,j,graph,visi,n,m);
              
              int ans = fact[sum];
              res = (int)(((long)res * ans)%mod);
            }
          }
        }
        System.out.println(res);
      }
	}

}