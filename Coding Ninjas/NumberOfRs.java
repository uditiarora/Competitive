import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      s.nextLine();
      while(t--!=0){
        String str=s.nextLine();
        int n =str.length();
        int arr[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
          if(str.charAt(i)=='R'){
            arr[i]=-1;
            count++;
          }
          else{
            arr[i]=1;
            
          }
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        int ans=arr[0];
        for(int i=1;i<n;i++){
          dp[i] = Math.max(arr[i],arr[i]+dp[i-1]);
          ans = Math.max(ans,dp[i]);
        }
        ans = ans+count;
        System.out.println(ans);
      }
	}

}