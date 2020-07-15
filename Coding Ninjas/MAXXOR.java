import java.util.*;
import java.io.*;
class Node{
  Node left,right;
}
public class Main {

  public static void insert(int pre,Node head){
    int x = 0;
    Node temp = head;
    for(int i=31;i>=0;i--){
      x = (pre>>i)&1;
      if(x==0){
        if(temp.left==null){
          temp.left = new Node();
        }
        
          temp = temp.left;
        
      }
      else{
        if(temp.right==null){
          temp.right = new Node();
          
        }
        
          temp = temp.right;
        
      }
    }
    
  }
  public static int util(Node head, int pre){
    int res=0;
    Node temp = head;
    for(int i=31;i>=0;i--){
      int b = (pre>>i)&1;
      if(b==0){
        if(temp.right==null){
          temp = temp.left;
        }
        else{
          temp = temp.right;
          res += Math.pow(2,i);
        }
      }
      else{
        if(temp.left==null){
          temp = temp.right;
        }
        else{
          temp = temp.left;
          res += Math.pow(2,i);
        }
      }
    }
    return res;
  }
	
	public static void main(String[] args) throws IOException{
		// Write your code here
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int pre=0;
		int max = 0;
		Node head = new Node();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
			pre = pre^arr[i];
			insert(pre,head);
			max = Math.max(max, util(head,pre));
			
		}
		System.out.println(max);

	}

}