import java.util.Scanner;

public class Main {

	
  
  
  public static void build(int arr[],int tree[],int start,int end,int treeNode){
      if(start==end){
       		if(arr[start]%2==1){
              tree[treeNode] = 1;
            }
          return;
      }
      int mid = (start+end)/2;
      build(arr,tree,start,mid,treeNode*2);
      build(arr,tree,mid+1,end,1 + treeNode*2);
      tree[treeNode] = tree[treeNode*2] + tree[treeNode*2 + 1];
      
      
      
    }
  
  public static int query(int[] tree,int start,int end,int treeNode,int left,int right){
    if(start>=left && end<=right){
      return tree[treeNode];
    }
    if(end<left || start>right){
      return 0;
    }
    int mid = (start+end)/2;
    return query(tree,start,mid,treeNode*2,left,right)+query(tree,mid+1,end,treeNode*2 + 1,left,right);
    
  }
  
  public static void update(int index,int value,int[] tree,int arr[],int start,int end,int treeNode){
    if(start==end){
      arr[start]=value;
      if(value%2==1){
        tree[treeNode]=1;
      }
      else{
        tree[treeNode]=0;
      }
      return;
    }
    
    int mid = (start+end)/2;
    if(index>mid){
      update(index,value,tree,arr,mid+1,end,treeNode*2+1);
    }
    else{
      update(index,value,tree,arr,start,mid,treeNode*2);
    }
    tree[treeNode] = tree[treeNode*2] + tree[treeNode*2 + 1];
    
  }
  
	public static void main(String[] args) {
		// Write your code here
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++){
        arr[i] = s.nextInt();
      }
      int tree[] = new int[4*n];
      int q = s.nextInt();

      build(arr,tree,0,n-1,1);
      
      //s.nextLine();
      while(q--!=0){
    	 // s.nextLine();
    	  int x = s.nextInt();
        if(x==0){
        	int index = s.nextInt();
        	int value = s.nextInt();
        	update(index-1,value,tree,arr,0,n-1,1);
        }
        else{
        	int a= s.nextInt();
        	int b = s.nextInt();
        	int ans = query(tree,0,n-1,1,a-1,b-1);
        	if(x==1){
        		System.out.println((b-a+1)-ans);
        	}
        	else{
        		System.out.println(ans);
        	}
        }
      }
	}

}