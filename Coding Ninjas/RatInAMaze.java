

public class Solution {
	
	
	
	public static void ratInAMaze(int maze[][]){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */
		int n = maze.length;
          int ans[][] = new int[n][n];
      print(maze,ans,0,0);
	}
	public static void print(int[][] maze,int[][] ans,int r,int c){
            int n = maze.length;

      if(r==n-1 && c==n-1){
        ans[r][c]=1;
        for(int i=0;i<maze.length;i++){
          for(int j=0;j<maze.length;j++){
            System.out.print(ans[i][j]+" ");
          }
        }
        System.out.println();
        return;
      }
      if(r<0 || r>=n || c<0 || c>=n || ans[r][c]==1 || maze[r][c]==0){
        return;
      }
      ans[r][c] = 1;
      if(r-1>=0 && maze[r-1][c]==1){
        print(maze,ans,r-1,c);
      }
      if(r+1<n && maze[r+1][c]==1){
        print(maze,ans,r+1,c);
      }
      if(c-1>=0 && maze[r][c-1]==1){
        print(maze,ans,r,c-1);
      }
      if(c+1<n && maze[r][c+1]==1){
        print(maze,ans,r,c+1);
      }
      
      ans[r][c] = 0;
      
      
      
      
    }
	
	
}
