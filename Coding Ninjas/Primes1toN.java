
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      boolean arr[] = new boolean[n+1];
      Arrays.fill(arr,true);
      for(int i=2;i*i <= n;i++){
        if(arr[i]==true){
        for(int j=i*2;j<=n;j+=i){
          arr[j] = false;
        }
        }
      }
      int count =0;
      for(int i=2;i<=n;i++){
        if(arr[i]==true){
          count++;
        }
      }
      System.out.println(count);
      
	}

}