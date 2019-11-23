
public class Solution {

	
	public static int countWaysToMakeChange(int arr[], int value){

		
      
      int dp[]= new int[value+1];
      dp[0]=1;
      int n =arr.length;
      for(int i=0;i<n;i++){
        for(int j=arr[i];j<=value;j++){
          dp[j]=dp[j]+dp[j-arr[i]];
        }
      }
      return dp[value];
      

	}
	
}
