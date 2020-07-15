import java.util.*;
import java.io.*;
class Node{
  Node left,right;
  int leafR,leafL;
}
public class Main {

  
  public static void insert(Node head,int pre){
    Node temp = head;
    for(int i=31;i>=0;i--){
      int b = (pre>>i)&1;
      if(b==0){
        temp.leafL += 1;
        if(temp.left==null){
          temp.left = new Node();
        }
        temp = temp.left;
      }
      else{
        temp.leafR += 1;
        if(temp.right==null){
          temp.right = new Node();
        }
        temp = temp.right;
      }
    }
  }
  public static int util(Node head,int k,int pre){
    Node temp = head;
    int ans=0;
    for(int i=31;i>=0;i--){
      int a = (k>>i)&1;
      int b = (pre>>i)&1;
      if(a==1 && b==1 && temp!=null){
        ans += temp.leafR;
        temp = temp.left;
      }
      else if(a==1 && b==0 && temp!=null){
        temp = temp.right;
      }
      else if(a==0 && b==1 && temp!=null){
        ans += temp.leafL;
        temp = temp.right;
      }
      else if(a==0 && b==0 && temp!=null){
        temp = temp.left;
      }
       
    }
    return ans;
  }
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st ;
      int t = Integer.parseInt(br.readLine());
      while(t--!=0){
        Node head = new Node();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = Integer.parseInt(st.nextToken());
          
        }
        int pre = 0,res=0;
        for(int i=0;i<n;i++){
          pre = pre^arr[i];

          res += util(head,k,pre);
          insert(head,pre);

        }
        System.out.println(res);
      }
      
      
      
	}

}