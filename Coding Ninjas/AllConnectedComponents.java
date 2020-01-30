import java.util.*;

public class Solution {
public static LinkedList<Integer> util(int arr[][] , int visited[],int v,LinkedList<Integer> temp){
  temp.add(v);
  for(int i=0;i<arr.length;i++){
    if(arr[v][i] == 1 && visited[i]==0){
      visited[i]=1;
      //temp.add(i);
      util(arr,visited,i,temp);
    }
  }
  return temp;
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
      
      int arr[][] = new int[v][v];
      for(int i=0;i<e;i++){
        int a = s.nextInt();
        int b= s.nextInt();
        arr[a][b] = arr[b][a] = 1;
      }
  LinkedList<Integer> temp = new LinkedList<Integer>();
      int visited[] = new int[v];
      for(int i=0;i<v;i++){
        if(visited[i] == 0){
          visited[i] = 1;
          temp = util(arr,visited,i,new LinkedList<Integer>());
          Collections.sort(temp);
          for(int j=0;j<temp.size();j++){
            System.out.print(temp.get(j)+" ");
          }
          System.out.println();
        }
      }
      
      
	}
}