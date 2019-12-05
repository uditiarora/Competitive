import java.util.*;
import java.io.*;
public class Main {
	static int N = (int)Math.pow(10, 6)+10;
	static int max[] = new int[N];
	static int min[] = new int[N];
	static int tree[] =new int[4*N];
	public static void build(int start,int end,int treeNode){
		
		if(start==end){
			tree[treeNode] = start;
			return;
		}
		
		int mid = (start+end)/2;
		build(start,mid,2*treeNode);
		build(mid+1,end,2*treeNode+1);
		int left = tree[treeNode*2];
		int right = tree[treeNode*2 +1];
		if(max[right] > max[left]){
			tree[treeNode] = right;
		}
		else if(max[right]<max[left]){
			tree[treeNode] = left;
		}
		else{
			if(min[right]<min[left]){
				tree[treeNode] = right;
			}
			else if(min[right]>min[left]){
				tree[treeNode] = left;
				
			}
			else{
				tree[treeNode] = Math.min(left,right);
			}
		}
		
	}
	public static void update(int index,int value,int tree[],int arr[],int start,int end,int treeNode){
		if(start == end){
			tree[treeNode] = value%2;
			arr[index] = value;
			return;
		}
		int mid = (start+end)/2;
		if(index>mid){
			update(index,value,tree,arr,mid+1,end,treeNode*2 +1);
		}
		else{
			update(index,value,tree,arr,start,mid,treeNode*2);
		}
		
		tree[treeNode] = tree[treeNode*2] + tree[treeNode*2+1];
		
	}
	public static int query(int start,int end,int treeNode,int l,int r){
		if(start>=l && end<=r){
			return tree[treeNode];
		}
		if(start>r || end<l){
			return 0;
		}
		
		int mid = (start+end)/2;
		int left = query(start,mid,treeNode*2,l,r);
		int right = query(mid+1,end,treeNode*2 + 1,l,r);
		if(max[right] > max[left]){
			return right;
		}
		else if(max[right]<max[left]){
			return left;
		}
		else{
			if(min[right]<min[left]){
				return right;
			}
			else if(min[right]>min[left]){
				return left;
				
			}
			else{
				return Math.min(left,right);
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++){
    	  max[i] = Integer.parseInt(st.nextToken());
    	  
      }
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=n;i++){
    	  min[i] = Integer.parseInt(st.nextToken());
    	  
      }
      
      int q = Integer.parseInt(br.readLine());
      build(1,n,1);
      while(q--!=0){
    	  st = new StringTokenizer(br.readLine());
    	  int x = Integer.parseInt(st.nextToken());
    	  int y = Integer.parseInt(st.nextToken());
    	  System.out.println(query(1,n, 1, x, y));
      }
      
      
      
      
	}

}
