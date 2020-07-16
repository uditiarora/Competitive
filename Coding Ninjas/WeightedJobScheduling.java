import java.util.*;
class pair implements Comparable<pair>{
  int start,finish,profit;
  public int compareTo(pair temp){
    return this.finish - temp.finish;
  }
}

public class Main {
	public static int binarySearch(pair arr[], int i){
      int hi = i - 1,lo = 0;
      int mid = 0 ;
      while(lo<=hi){
        mid = (lo+hi)/2;
        if(arr[mid].finish<=arr[i].start){
          if(arr[mid+1].finish<=arr[i].start){
            lo = mid+1;
            
          }
          else{
            return mid;
          }
        }
        else{
          hi = mid-1;
        }
        
      }
      return -1;
    }
	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      	int n = s.nextInt();
      pair[] arr = new pair[n];
      for(int i=0;i<n;i++){
        arr[i] = new pair();
        arr[i].start = s.nextInt();
        arr[i].finish = s.nextInt();
        arr[i].profit = s.nextInt();
        
      }
      int dp[] = new int[n+1];
      Arrays.sort(arr);
      dp[0] = arr[0].profit;
      for(int i=1;i<n;i++){
        int incl = arr[i].profit;
        int x = binarySearch(arr,i);
        if(x!=-1){
          incl += dp[x];
        }
        dp[i] = Math.max(incl,dp[i-1]);
      }
      
      System.out.println(dp[n-1]);
      
	}

}