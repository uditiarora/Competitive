import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int t = s.nextInt();
      int arr[] = new int [n+1];
      for(int i=1;i<n;i++){
        arr[i] = s.nextInt() + i;
      }
      boolean visi[] = new boolean[n+1];
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(1);
      visi[1] = true;
      boolean flag=false;
      int x=1;
      while(!q.isEmpty()){
        x = q.poll();
        if(x==t){
          flag = true;
          break;
        }
        if(visi[arr[x]]==false){
        	visi[arr[x]] = true;
          q.add(arr[x]);
        }
      }
      if(flag==false){
        System.out.println("NO");
        
      }
      else{
        System.out.println("YES");
      }
	}

}