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
        arr[a][b] = arr[b][a] = 1;
        
      }
      
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(0);
      visited[0]=1;
      while(!q.isEmpty()){
        int p = q.remove();
    
        for(int i=0;i<v;i++){
          if(arr[p][i] == 1 && visited[i] == 0){
            q.add(i);
            visited[i]=1;
          }
        }
        System.out.print(p+" ");
      }
      
	}
}