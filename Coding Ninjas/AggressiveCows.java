import java.util.*;
import java.io.*;
public class Main {

	public static boolean util(long mid,long arr[],int c){
      long pos = arr[0],count=1;
      for(int i=1;i<arr.length;i++){
        if(arr[i]-pos >= mid){
          count++;
          pos = arr[i];
        }
      }
      
      if(count<c) return false;
      return true;
      
    }
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t--!=0){
        int n = s.nextInt();
        int c = s.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
          arr[i] = s.nextLong();
        }
        Arrays.sort(arr);
        long low = 1,high = arr[n-1]-arr[0],mid=0,ans=0;
        while(low<=high){
          mid = (low+high)/2;
          if(util(mid,arr,c)){
            low = mid+1;
            ans=mid;
          }
          else{
            high = mid-1;
          }
        }
        System.out.println(ans);
        
        
        
      }
      
      
      
	}

}