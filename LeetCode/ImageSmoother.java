class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] ans = new int[M.length][M[0].length];        
        for(int i = 0;i < M.length;i++){            
            for(int j = 0;j < M[0].length;j++){
                
                int[][] d = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, 
                             {1, 0}, {1, -1}, {0, -1},{-1, -1}};
                 int cnt = 0;
                 int total = 0;
                for(int[] xy : d){                    
                    if(i + xy[0] < 0 || i + xy[0] >= M.length || j + xy[1] < 0 || j + xy[1] >= M[0].length){
                        continue;
                    }
                    total++;
                    cnt += M[i + xy[0]][j + xy[1]] ;
                }
                ans[i][j] = (int)Math.floor(cnt/total);
            }
        }
        return ans;
    }
}