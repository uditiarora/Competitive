import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	
	public static void main(String[] args) throws IOException{
		// Write your code here
      
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      
      int n = Integer.parseInt(br.readLine());
      int arr[]=new int[n+2];
      int t = Integer.parseInt(br.readLine());
      while(t--!=0){
    	  StringTokenizer st =new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        arr[a] = arr[a]+1;
        arr[b+1] = arr[b+1]-1;
        
      }
      arr[0]=0;
       int temp = Math.max(n,t)+1;
      int dp[] = new int[temp];
      for(int i=1;i<=n;i++){
        arr[i]=arr[i]+arr[i-1];
        dp[arr[i]]++;
      }
     
     
      
      for(int i=temp-2;i>=0;i--){
        dp[i] = dp[i]+dp[i+1];
      }
      
		int q = Integer.parseInt(br.readLine());
      while(q--!=0){
        int a = Integer.parseInt(br.readLine());
        
        
        System.out.println(dp[a]);
      }
	}

}
