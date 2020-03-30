import java.util.*;

class graph implements Comparable<graph>{
	int f,t,w;
	public graph(int f,int t,int w){
		this.f=f;
		this.t=t;
		this.w=w;
		
	}
	public int compareTo(graph temp){
		return this.w-temp.w;
	}
}

public class Solution {
	public static int parent(int x,int[] par){
		if(par[x] == x){
			return x;
		}
		return parent(par[x],par);
	}
	public static void union(int[] par,int x,int y){
		par[y] = x;
	}
  public static void main(String[] args) {
	
	  Scanner s = new Scanner(System.in);
	  int v = s.nextInt();
	  int e = s.nextInt();
	  int[] par = new int[v+1];
	  int f,t,w;
	  graph arr[] = new graph[e];
	  for(int i=0;i<e;i++){
		  f = s.nextInt();
		  t = s.nextInt();
		  w = s.nextInt();
		  arr[i] = new graph(f,t,w);
		  
	  }
	  for(int i=0;i<v;i++){
		  par[i]=i;
	  }
	  Arrays.sort(arr);
	  
	  int i = 0,j=0;
	  while(i<v-1){
		  int x = parent(arr[j].f,par);
		  int y = parent(arr[j].t,par);
		  if(x!=y){
            if(arr[j].f<arr[j].t){
			  System.out.println(arr[j].f+" "+arr[j].t+" "+arr[j].w);
            }
            else{
        			  System.out.println(arr[j].t+" "+arr[j].f+" "+arr[j].w);
 
            }
			  i++;
			  union(par,arr[j].f,arr[j].t);
		  }
		  j++;
	  }
	  
	}
	
  
  
  
  
}
