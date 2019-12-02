import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
		    
	public static void main(String[] args) throws IOException{
		// Write your code here
      Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = s.nextInt();
		int m = s.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0;i<n;i++){
			//st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				arr[i][j] = s.nextInt();
			}
		}
		
		
		
		int dp[][] = new int[n][m+2];
		for(int i=0;i<n;i++){
			dp[i][0] = dp[i][m+1] = Integer.MAX_VALUE;
		}
		for(int i=1;i<=m;i++){
			dp[0][i] = arr[0][i-1];
		}
		int ans = Integer.MAX_VALUE;
		
		for(int i=1;i<n;i++){
			for(int j=1;j<=m;j++){
				dp[i][j] = arr[i][j-1] + Math.min(dp[i-1][j],Math.min(dp[i-1][j+1], dp[i-1][j-1]));
			}
		}
		for(int i=1;i<=m;i++){
			ans = Math.min(ans, dp[n-1][i]);
		}
		System.out.println(ans);
      }
	}

