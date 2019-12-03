import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
  static int mod = (int)(Math.pow(10,9))+7;
	public static void util(int arr[],String str){
		int n = str.length();
		long dp[] = new long[n+1];
      long sum[] = new long[n+1];
		dp[0] = 1;
      sum[0]=1;
      dp[1] = 1;
      sum[1]=2;
      arr[str.charAt(0)-'A'] = 1;
		for(int i=2;i<=n;i++){
			dp[i] = sum[i-1];
          if(arr[str.charAt(i-1)-'A']!=-1){
            dp[i]-=sum[arr[str.charAt(i-1)-'A']-1];
          }
            sum[i] = (sum[i-1]+dp[i])%mod;
            if(sum[i]<0){
              sum[i]+=mod;
            }
            arr[str.charAt(i-1)-'A'] = i;
          
		}
		System.out.println(sum[n]);
	
	}
	
	
	public static void main(String[] args)throws IOException{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
      	s.nextLine();
		while(t--!=0){
			String str = s.nextLine();
			int arr[]=new int[27];
			Arrays.fill(arr, -1);
			util(arr,str);
		}
				
	}
}

