import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	
	public static void main(String[] args) throws IOException {
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int arr[]= new int[n];
      st = new StringTokenizer(br.readLine());
      int dp[]=new int[1024];
		int dp2[]=new int[1024];
      for(int i=0;i<n;i++){
        arr[i] = Integer.parseInt(st.nextToken());
        dp[arr[i]]++;
      }
      boolean first=true;
      
      for(int i=0;i<t;i++){
        int flag=0;
        for(int j=0;j<1024;j++){
          if(dp[j]!=0){
            if(dp[j]%2 == 0){
              int temp = j^x;
              dp2[j] =dp2[j]+dp[j]/2;
              dp2[temp] = dp2[temp] + dp[j]/2;
              flag = flag+dp[j];
            }
            else{
              int count1=0 , count2=0;
              if(flag%2 == 0){
                 count1 = dp[j]/2 + 1;
                count2 = dp[j]/2;
              }
              else{
                count1=dp[j]/2;
                count2 = dp[j]/2+1;
              }
              
              dp2[j] = dp2[j]+ count2;
              int temp = j^x;
              dp2[temp] = dp2[temp]+count1;
              flag=flag+dp[j];
            }
          }
        }
        for(int k=0;k<1024;k++){
          dp[k] = dp2[k];
          //System.out.print(dp[k]+" ");
          dp2[k]=0;
        }
        
      }
      int min=0,max=0;
      
      for(int i=0;i<1023;i++){
        if(dp[i]!=0){
          min=i;
          break;
        }
      }
      for(int i=1023;i>=0;i--){
        if(dp[i]!=0){
          max=i;
          break;
        }
      }
      System.out.println(max+" "+min);
	}

}