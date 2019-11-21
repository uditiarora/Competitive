import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s =new Scanner(System.in);
      int mod = (int)Math.pow(10,9)+7;
      while(true){
        String str=s.nextLine();
       
        int n =str.length();
        long dp[]=new long[n+1];
        dp[0]=dp[1]=1;
        
        for(int i=2;i<=n;i++){
          int temp=((str.charAt(i-2)-'0')*10 + (str.charAt(i-1)-'0'));
          if(str.charAt(i-1)=='0'){
            if(temp<=26 && temp>0){
              dp[i]=((long)dp[i]+dp[i-2])%mod;
              continue;
            }
            else{
              break;
            }
          }
          if(temp<=26){
            dp[i] = (((long)dp[i]+dp[i-2])%mod);
          }
          if(str.charAt(i-2)!='0'){
            dp[i] = (((long)dp[i]+dp[i-1])%mod);
          }
        }
        
        System.out.println(dp[n]);
      }
		
	}

}