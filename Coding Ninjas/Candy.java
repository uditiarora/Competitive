
public class solution {
	
	long solve(int[][] like,int n){
		
		//Write your code here.
		long dp[] = new long[(1<<n)];
      dp[(1<<n)-1] = 1;
      for(int i = (1<<n)-2;i>=0;i--){
        int temp=i,k=0;
        while(temp!=0){
          k = k+(temp&1);
          temp = temp/2;
          
        }
        for(int j=0;j<n;j++){
          if(like[k][j]==1 && ((1<<j) & i)==0){
            dp[i] = dp[i] + dp[i | (1<<j)];
          }
        }
        
        
      }
      
      return dp[0];
      
	}
	
}
