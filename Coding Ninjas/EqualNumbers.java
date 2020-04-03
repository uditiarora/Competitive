import java.util.*;
import java.io.*;

public class Main {
	static int dp[][] = new int[105][100005];
	static int freq[] = new int[100005];
	public static void main(String[] args) throws IOException{
		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n+1];
		for(int i=1;i<=n;i++){
			arr[i] = s.nextInt();
		}
		int pre[] = new int[n+1];
		for(int i=1;i<=n;i++){
			pre[i] = pre[i-1]+arr[i];
		}
		int max = Integer.MIN_VALUE;
		dp[0][0]=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=100000;j++){
				dp[i][j] = dp[i-1][j];
				for(int k=i-1;k>=0;k--){
					if(pre[i]-pre[k]==j){
						dp[i][j] = Math.max(dp[i][j],dp[k][j]+1);
					}
				}
				freq[j] = Math.max(freq[j], dp[i][j]);
				max = Math.max(max, freq[j]);
			}
			
		}
		System.out.println(max);
		for(int i=0;i<=100000;i++){
			if(freq[i]==max){
				System.out.print(i+" ");
			}
		}
      
	}

}