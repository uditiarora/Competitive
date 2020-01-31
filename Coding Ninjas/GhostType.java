import java.util.*;

public class Main {

	static long dp[] = new long[1<<20];
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      int z = (int)Math.pow(2,n);
      LinkedList<Integer> temp = new LinkedList<Integer>();
      for(int i=0;i<n;i++){
        dp[(1<<i)] = 1;
      }
      for(int i=0;i<z;i++){
        temp.clear();
        for(int j=0;j<n;j++){
          if((1 & (i>>j))==1){
            temp.add(j+1);
          }
        }
        
        for(int j=0;j<n;j++){
          if((1 & (i>>j))==0){
           int f=0;
            for(int k=0;k<temp.size();k++){
              if((temp.get(k) & (j+1))==(j+1)){
                f=1;
                break;
              }
            }
            if(f==0){
              dp[i | (1<<j)] += dp[i];
            }
          }
        }
        
        
        
      }
      System.out.println(dp[z-1]);
      
      
	}

}