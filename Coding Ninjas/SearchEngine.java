import java.util.*;
class Node{
  int w ;
  Node child[];
  public Node(){
    w = 0;
    child = new Node[26];
    Arrays.fill(child, null);
  }
}
public class Main {

	public static void insert(Node head,String str,int w){
		int n = str.length();
		Node temp = head;
		for(int i=0;i<n;i++){
			int index = str.charAt(i)-'a';
			if(temp.w<w){
				temp.w = w;
			}
			if(temp.child[index]==null){
				temp.child[index] = new Node();
				temp = temp.child[index];
			}
			else{
				temp = temp.child[index];
				
			}
			
		}
	}
	
	public static int query(Node head,String str){
		int ans=-1;
		Node temp = head;
		int n = str.length();
		for(int i=0;i<n;i++){
			int index = str.charAt(i)-'a';
			if(temp.child[index]!=null){
				ans = temp.child[index].w;
			}
			else{
				//System.out.println(i);
				return -1;
			}
			temp = temp.child[index];
		}
		return ans;
	}
	public static void main(String[] args) {
		// Write your code here
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int q = s.nextInt();
      Node head = new Node();
      
      for(int i=0;i<n;i++){
    	  String str = s.next();
    	  int w = s.nextInt();
    	  insert(head,str,w);
      }
      for(int i=0;i<q;i++){
    	  String str = s.next();
    	  System.out.println(query(head,str));
      }

	}

}