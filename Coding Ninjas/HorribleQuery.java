

import java.util.*;
import java.io.*;
public class Main{
	static int N = (int)Math.pow(10,5)+10;
	
	//static long arr[] = new long[N];
	static long tree[] = new long[4*N];
	static long lazy[] = new long[4*N];
	public static void update(int start,int end,int left,int right,int treeNode,long v){
		if(lazy[treeNode]!=0){
			tree[treeNode]+=(end - start+1)*lazy[treeNode];
			if(start!=end){
				lazy[treeNode*2] += lazy[treeNode];
				lazy[treeNode*2 +1] += lazy[treeNode];
			}
			lazy[treeNode]=0;
		}
		if(start>right || start>end || end<left){
			return;		
		}
		if(start>=left && end<=right){
			tree[treeNode] += (end-start+1)*v;
			if(start!=end){
				lazy[treeNode * 2]+=v;
				lazy[treeNode*2 + 1]+=v;
			
			} 
			return;
		}
		
		int mid = (start+end)/2;
		update(start,mid,left,right,treeNode*2,v);
		update(mid+1,end,left,right,treeNode*2 + 1,v);
		tree[treeNode] = tree[treeNode*2] + tree[treeNode * 2 +1];
		
	
	}
	public static long query(int start,int end,int left,int right,int treeNode){
	
		if(lazy[treeNode]!=0){
			tree[treeNode]+=(end - start+1)*lazy[treeNode];
			if(start!=end){
				lazy[treeNode*2] += lazy[treeNode];
				lazy[treeNode*2 +1] += lazy[treeNode];
			}
			lazy[treeNode]=0;
		}
		if(start>right || start>end || end<left){
			return 0;		
		}
		if(start>=left && end<=right){
			return tree[treeNode];
		}
		
		int mid = (start+end)/2;
		return query(start,mid,left,right,treeNode*2) + query(mid+1,end,left,right,treeNode * 2 +1);
		
	
	} 
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t--!=0){
			Arrays.fill(lazy,0);
			Arrays.fill(tree,0);
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			while(q--!=0){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				if(x==1){
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					System.out.println(query(1,n,a,b,1));
				}
				else{
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					long v = Long.parseLong(st.nextToken());
					update(1, n, a, b, 1, v);
				}
			
			}
		}
	
	}



}