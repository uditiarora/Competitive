import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {

	
	public static void main(String[] args) throws IOException {
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
		int arr[][] = new int[m][n];
      for(int i=0;i<m;i++){
          st = new StringTokenizer(br.readLine());

        for(int j=0;j<n;j++){
			arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int dp[][] = new int[m+1][n+1];
      for(int i=1;i<=n;i++){
        dp[1][i]=1;
      }
      for(int i=1;i<=n;i++){
        for(int j=2;j<=m;j++){
          if(arr[j-1][i-1]>=arr[j-2][i-1]){
            dp[j][i] = dp[j-1][i];
          }
          else{
            dp[j][i] = j;
          }
        }
      }
      
      int dp2[] = new int[m+1];
      for(int i=1;i<=m;i++){
        int min = Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
          if(dp[i][j]<min){
            min = dp[i][j];
          }
        }
        dp2[i] = min;
      }
      
      
      int t = Integer.parseInt(br.readLine());
      for(int i =0;i<t;i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(dp2[b]<=a){
          System.out.println("Yes");
        }
        else{
          System.out.println("No");
        }
      }
      
	}

}