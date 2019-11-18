class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = Math.max(grid[0][0], grid[grid.length-1][grid[0].length-1]);
        int high = n*n-1;
        int mid = 0;
        int ans = 0;
        while(low<high){
            mid = low + (high-low)/2;
            if(util(grid,mid)){
                ans = mid;
                high = mid;
            }
            else{
                low = mid+1;
            }
            
        }
        return high;
        
    }
     private boolean util(int[][] grid, int level) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited, level);
    }
            
    private int[][] neighbors = new int[][] {{1, 0}, {-1, 0}, {0, 1} , {0, -1}};
    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited, int level) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        
        if(visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        if(grid[i][j] > level) {
            return false;
        }
        
        if(i == grid.length- 1 && j == grid[0].length - 1) {
            return true;
        }
        
        for(int[] neighbor : this.neighbors) {
            if(dfs(grid, i + neighbor[0], j + neighbor[1], visited, level)) {
                return true;
            }
        }
        
        return false;
    }
}