import java.util.*;
class pair{
    int a,b;
    
    public pair(int a,int b){
      this.a = a;
      this.b = b;
    }
  }
public class Main {
 
  static int arr[][] = new int[505][505];
  static Stack<pair> path = new Stack<pair>();
  static int size =0 ;
	public static boolean util(int n,int m,int x,int y,int j){
      if(x==1 || x==n || y==1 || y==m){
        path.push(new pair(x,y));
        size++;
        return true;
      }
      if((arr[x][y]>= arr[x-1][y])  && (arr[x][y] - arr[x-1][y] <= j) && util(m,n,x-1,y,j)){
        path.push(new pair(x,y));
        size++;
        return true;
      }
      if((arr[x][y]>= arr[x][y-1])  && (arr[x][y] - arr[x][y-1] <= j) && util(m,n,x,y-1,j)){
        path.push(new pair(x,y));
        size++;
        return true;
      }
      if((arr[x][y]>= arr[x+1][y])  && (arr[x][y] - arr[x+1][y] <= j) && util(m,n,x+1,y,j)){
        path.push(new pair(x,y));
        size++;
        return true;
      }
      if((arr[x][y]>= arr[x][y+1])  && (arr[x][y] - arr[x][y+1] <= j) && util(m,n,x,y+1,j)){
        path.push(new pair(x,y));
        size++;
        return true;
      }
      return false;
    }
	
	public static void main(String[] args) {
		// Write your code here
	Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int m = s.nextInt();
      for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
          arr[i][j] = s.nextInt();
        }
      }
      
      int x = s.nextInt();
      int y = s.nextInt();
      int j = s.nextInt();
      if(util(n,m,x,y,j)){
        System.out.println("YES");
      System.out.println(size);
      while(!path.isEmpty()){
    	  pair temp = path.pop();
    	  System.out.println(temp.a+" "+temp.b);
      }
      }
      else{
        System.out.println("NO");
      }
      
	}

}