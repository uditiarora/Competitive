import java.util.*;
import java.io.*;
class node{
  	int max,smax;
}
public class Main{

  static int N = (int)Math.pow(10, 5);
	static int[] arr = new int[N+1];
	static node[] tree = new node[4*N + 1];
   public static void build(int start,int end,int treeNode){
      tree[treeNode] = new node();

      if(start==end){
        tree[treeNode].max = arr[start];
        tree[treeNode].smax = Integer.MIN_VALUE;
          return;
      }
      int mid = (start+end)/2;
      build(start,mid,treeNode*2);
      build(mid+1,end,1 + treeNode*2);
     node ans1 = tree[treeNode*2];
     node ans2 = tree[treeNode*2 +1];
     tree[treeNode].max = Math.max(ans1.max,ans2.max);
     tree[treeNode].smax = Math.min(Math.max(ans1.max,ans2.smax),Math.max(ans1.smax,ans2.max));
      
      
      
    }
  
  public static node query(int start,int end,int treeNode,int left,int right){
        node temp = new node();

    if(start>=left && end<=right){
    	return tree[treeNode];
    }
    if(end<left || start>right){
		temp.max = Integer.MIN_VALUE;
      temp.smax = Integer.MAX_VALUE;
      return temp;    
    }
    int mid = (start+end)/2;
    node ans1= query(start,mid,treeNode*2,left,right);
    node ans2 = query(mid+1,end,treeNode*2 + 1,left,right);
    temp.max = Math.max(ans1.max,ans2.max);
    temp.smax = Math.min(Math.max(ans1.max,ans2.smax),Math.max(ans2.max,ans1.smax));  
    return temp;
  }
  
  public static void update(int index,int value,int start,int end,int treeNode){
   	if(start == end){
          
			tree[treeNode].max = value;
			tree[treeNode].smax=Integer.MIN_VALUE;
			//arr[index] = value;
			return;
		}
		int mid = (start+end)/2;
		if(index>mid){
			update(index,value,mid+1,end,treeNode*2 +1);
		}
		else{
			update(index,value,start,mid,treeNode*2);
		}
		
		node left = tree[treeNode*2];
		node right = tree[treeNode*2+1];
		tree[treeNode].max = Math.max(left.max, right.max);
		tree[treeNode].smax = Math.min(Math.max(left.max, right.smax), Math.max(left.smax, right.max));
    
  }
  
  
  
  
  
  
	
	public static void main(String[] args) throws IOException{
		// Write your code here
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int q = Integer.parseInt(br.readLine());
		build(0,n-1,1);
		while(q--!=0){
          st = new StringTokenizer(br.readLine());
          
			char x = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x=='Q'){
				node ans = query(0,n-1,1,a-1,b-1);
				int temp = ans.max + ans.smax;
				System.out.println(temp);
			}
			else{
				update(a-1,b,0,n-1,1);
			}
		}

	}

}