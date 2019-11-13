
public class Solution {
	
	
	
	public static boolean sudokuSolver(int board[][]){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Don't print output and return output as specified in the question.
	 */
		return util(board);
	}
  public static boolean safe(int arr[][],int r,int c,int k){
    for(int i=0;i<9;i++){
      if(arr[r][i]==k){
        return false;
      }
    }
    for(int i=0;i<9;i++){
      if(arr[i][c]==k){
        return false;
      }
    }
    
   int row = r - r%3;
    int col = c - c%3;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        if(arr[row+i][col+j]==k){
          return false;
        }
      }
    }
    return true;
    
  }
	public static boolean util(int arr[][]){
      int flag=0 , r=-1,c=-1;
      for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
          if(arr[i][j] == 0){
            r = i;
            c = j;
            flag=1;
            break;
          }
        }
        if(flag==1) break;
      }
      if(r==-1 || c==-1){
        return true;
      }
      for(int i=1;i<=9;i++){
        if(safe(arr,r,c,i)){
          arr[r][c]=i;
          if(util(arr)) return true;
          arr[r][c]=0;
        }
      }
      return false;
      
    }
	
	
}
