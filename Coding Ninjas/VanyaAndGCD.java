import java.util.*;
import java.io.*;

public class Main {	
	
	public static int gcd(int a,int b){
		if(a<b){
			int temp = a;
			a=b;
			b=temp;
		}
		while(b!=0){
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public static void main(String[] args) throws IOException{
		// Write your code here
		int mod = (int)Math.pow(10, 9)+7;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i] = s.nextInt();
		}
		int dp[][] = new int[n][102];
		int ans=0;
		for(int i=0;i<n;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[i]>arr[j]){
					for(int k=1;k<=100;k++){
						int temp  =gcd(arr[i],k);
						dp[i][temp] = (int)(((long)dp[i][temp] + dp[j][k])%mod);
					}
				
				}
			}
			dp[i][arr[i]] = (int)(((long)dp[i][arr[i]] + 1)%mod);
			ans = (int)(((long)ans + dp[i][1])%mod);
		}
		
		System.out.println(ans);
		
		
	}

}