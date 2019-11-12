
public class Solution {
	
		static int chess[][] = new int[11][11];
public static void placeNQueens(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */
	place(n,0);

	}
  public static boolean isSafe(int k,int i,int n){
    for(int j=k-1;j>=0;j--){
      if(chess[j][i]==1){
        return false;
      }
    }
    for(int j=k+1;j<n;j++){
      if(chess[j][i]==1){
        return false;
      }
    }
    
    for(int j=k-1,l=i-1;j>=0 && l>=0;j--,l-- ){
      if(chess[j][l]==1){
        return false;
      }
    } 
    for(int j=k-1,l=i+1; j>=0 && l<n;j--,l++){
      if(chess[j][l]==1){
        return false;
      }
    }
    return true;
    
  }
	public static void place(int n,int k){
      if(k==n){
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
            System.out.print(chess[i][j]+" ");
          }
        }
        System.out.println();
        return;
      }
      
      for(int i=0;i<n;i++){
        if(isSafe(k,i,n)){
          chess[k][i] = 1;
          place(n,k+1);
          chess[k][i] = 0;
        }
      }
      
      
    }
}
