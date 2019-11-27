import java.util.*;
public class Solution {

	public static boolean subsetSumToKIdentical(int input[],int n,int k){
	Arrays.sort(input);
	ArrayList<Integer> temp = new ArrayList<Integer>();
	
	int count=0;
	for(int i=0;i<n-1;i++){
		int c=1;
		while(i<n-1 && input[i]==input[i+1]){
			c++;
			i++;
		}
		temp.add(c*input[i]);
		
	}
	if(input[n-1]==input[n-2]){
		int temp2=temp.get(temp.size()-1);
		temp.remove(temp.size()-1);
		temp.add(temp2+input[n-1]);
	}
	else{
		temp.add(input[n-1]);
	}
	int arr2[] = new int[temp.size()];
	//boolean dp[]=new boolean[k+1];
	//dp[0]=true;
	count=arr2.length;
	for(int i=0;i<arr2.length;i++){
		arr2[i] = temp.get(i);
		//System.out.println(arr2[i]);
	}
	boolean dp[][] = new boolean[k+1][count+1];
    //dp[0] = true;
    for(int i=0;i<=count;i++){
      dp[0][i]=true;
    }
    for(int i=1;i<=k;i++){
      for(int j=1;j<=count;j++){
        dp[i][j] = dp[i][j-1];
        if(arr2[j-1] <= i){
          dp[i][j] = dp[i][j] || dp[i-arr2[j-1]][j-1];
        }
      }
    }
    return dp[k][count];
}
}

