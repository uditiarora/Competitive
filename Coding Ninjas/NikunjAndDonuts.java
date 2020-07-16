import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++){
        arr[i] = s.nextInt();
      }
      
      Arrays.sort(arr);
      long ans = 0,k=1;
      for(int i=n-1;i>=0;i--){
        ans += k*arr[i];
        k = k*2;
      }
      System.out.println(ans);
	}

}