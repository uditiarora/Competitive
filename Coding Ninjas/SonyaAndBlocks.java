import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
  
	static long dp[][] = new long[101][1001];
	static long arr[] = new long[100001];
	static long prefix[] = new long[100001];
	static long[] best = new long[1001]; 
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int k=1;k<=n;k++){
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for(int i=0;i<len;i++){
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			for(int i=0;i<len;i++){
				prefix[i+1] = prefix[i] + arr[i];
			}
			Arrays.fill(best, Integer.MIN_VALUE);
          best[0]=0;
			for(int i=1;i<=len;i++){
				for(int j=i;j<=len && j<i+m;j++){
					best[j-i+1] = Math.max(best[j-i+1], prefix[j]-prefix[i-1]);
				}
			}
			
			for(int j=0;j<=m;j++){
				for(int temp = 0;temp+j<=m;temp++){
					dp[k][temp+j] = Math.max(dp[k][j+temp], dp[k-1][j]+best[temp]);
				}
			}
			
		}
		System.out.println(dp[n][m]);
		
	}
}

