import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      int k=1;
      while(t--!=0){
        int n =s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i]=s.nextInt();
        }
        long dp[] = new long[n];
        dp[0]=arr[0];
        
        for(int i=1;i<n;i++){
          if(i>=2){
          dp[i] = Math.max((dp[i-2]+arr[i]),dp[i-1]);
          }
          else{
            dp[i]=Math.max(arr[1],arr[0]);
          }
        }
      System.out.println("Case "+k+": "+dp[n-1]);  
        k++;
      }
      

	}

}