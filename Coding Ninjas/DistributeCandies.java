import java.util.*;

public class Main {
	public static boolean util(int arr[],int mid,int k){
		if(mid==0) return true;
      int count=0;
      for(int i=arr.length-1;i>=0 && count<k;i--){
        int temp = arr[i]/mid;
        count += temp;
      }
      
      if(count>=k) return true;
      return false;
    }
	
	public static void main(String[] args) {
		// Write your code here
		
      	Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t--!=0){
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = s.nextInt();
        }
        
        Arrays.sort(arr);
        int low = 0,high = arr[n-1],mid=0,ans=0;
        while(low<=high){
        	mid = (high+low)/2;
          if(util(arr,mid,k)){
            low = mid+1;
            ans = mid;
          }
          else{
            high = mid-1;
          }
        }
        System.out.println(ans);
        
      }
      
      
      
	}

}