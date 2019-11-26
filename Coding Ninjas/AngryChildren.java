import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {

	
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      int arr[]=new int[n+1];
      arr[0]=-1;
      for(int i=1;i<=n;i++){
        arr[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(arr);
      long sum[]=new long[n+1];
      sum[1]=arr[1];
      for(int i=2;i<=n;i++){
        sum[i]=sum[i-1]+arr[i];
      }
      
      int val = 1-k;
      long answer =0,compare=0,previous=0;
      for(int i=1;i<=k;i++){
        answer = answer + (long)(val)*arr[i];
        val = val+2;
      }
      previous = answer;
      for(int i=k+1;i<=n;i++){
        compare = (long)(k-1) * arr[i];
        compare=previous + (long)(k-1)*arr[i] + (long)(k-1)*arr[i-k]-(long)2*(sum[i-1]-sum[i-k]);
		answer = Math.min(answer,compare);
        previous = compare;
      }
      System.out.println(answer);
	}

}