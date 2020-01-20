import java.util.*;

public class Solution {
public static void util(int arr[][],int visited[],int y,LinkedList<Integer> path,int s){
  if(s==y){
    for(int i=path.size()-1;i>=0;i--){
      System.out.print(path.get(i)+" ");
    }
    return;
  }
 
  //path.add(s);
  
  for(int i=0;i<arr.length;i++){
    if(arr[s][i] == 1 && visited[i]==0){
      visited[i]=1;
      path.add(i);
      
      util(arr,visited,y,path,i);
     	path.remove(path.size()-1);
    }
  }
  //visited[s] = 0;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
      LinkedList<Integer> path = new LinkedList<Integer>();
      int arr[][] = new int[v][v];
      int visited[] = new int[v];
      for(int i=0;i<e;i++){
        int a = s.nextInt();
        int b = s.nextInt();
        arr[a][b] = arr[b][a] = 1;
      }
      int x = s.nextInt();
      int y = s.nextInt();
      path.add(x);
      visited[x]=1;
      util(arr,visited,y,path,x);
      
	}
}