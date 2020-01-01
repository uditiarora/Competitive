import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
      int[][] arr = new int[v+1][v+1];
      int[] visited = new int[v];
     
      for(int i=0;i<e;i++){
        int a = s.nextInt();
        int b = s.nextInt();
        arr[a][b] =arr[b][a] = 1;
        
      }
       int x = s.nextInt();
      int y = s.nextInt();
      boolean flag = false;
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(x);
      visited[x]=1;
      while(!q.isEmpty() && flag==false){
        int p = q.remove();
    	if(p==y){
              flag=true;
              
           }
        for(int i=0;i<v;i++){
          if(arr[p][i] == 1 && visited[i] == 0){
            q.add(i);
            visited[i]=1;
            
          }
        }
        
        //System.out.print(p+" ");
      }
      System.out.println(flag);
	}
}