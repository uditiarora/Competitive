import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		//int arr[][] = new int[101][101];
		int dp[][][] = new int[101][101][11];
		for(int i=0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			for(int k=0;k<=c;k++){
				dp[x][y][k] += (s+k)%(c+1); 
			}
		}
	
		
		for(int i=1;i<101;i++){
			for(int j=1;j<101;j++){
				for(int k=0;k<=c;k++){
					dp[i][j][k]+= dp[i-1][j][k] + dp[i][j-1][k] - dp[i-1][j-1][k];
				}
			}
		}
		
		while(q--!=0){
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			t = t%(c+1);
			int ans = dp[x2][y2][t] - dp[x1-1][y2][t] - dp[x2][y1-1][t] + dp[x1-1][y1-1][t];
			System.out.println(ans);
		}
	   
				
	}
}

