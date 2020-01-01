class Solution {
    public int[][] rotate(int[][] matrix, int sc, int n) {
        for (int i = 0; i < n; i++) {
            int saved = matrix[sc][sc+i]; 
            matrix[sc][sc+i] = matrix[sc+n-i][sc]; 
            matrix[sc+n-i][sc] = matrix[sc+n][sc+n-i]; 
            matrix[sc+n][sc+n-i] = matrix[sc+i][sc+n]; 
            matrix[sc+i][sc+n] = saved;
        }
        return matrix;
    }
    
    public void rotate(int[][] matrix) {
        int x = 0;
        while (x < matrix.length/2) { 
            int n = matrix.length-1-2*x;
            matrix = rotate(matrix, x, n);
            x+=1;
        }
    }
}