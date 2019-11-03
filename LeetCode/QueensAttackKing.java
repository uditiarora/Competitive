class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int kx = king[0];
        int ky = king[1];
        int n = queens.length;
        boolean[][] pos = new boolean[8][8];
        for(int i=0;i<n;i++){
            pos[queens[i][0]][queens[i][1]] = true;
        }
        List<List<Integer>> ans =  new ArrayList<List<Integer>>();
        n = 8;
        for(int i=kx;i<n;i++){
            if(pos[i][ky]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(ky);
                ans.add(temp);
                break;
            }
        }
        for(int i=kx-1;i>=0;i--){
            if(pos[i][ky]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(ky);
                ans.add(temp);
                break;
            }
        }
        for(int i=ky;i<n;i++){
            if(pos[kx][i]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(kx);
                temp.add(i);
                ans.add(temp);
                break;
            }
        }
        for(int i=ky-1;i>=0;i--){
            if(pos[kx][i]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(kx);
                temp.add(i);
                ans.add(temp);
                break;
            }
        }
        for(int i=kx,j=ky;i<n && j<n;i++,j++){
            if(pos[i][j]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }
        for(int i=kx,j=ky;i<n && j>=0;i++,j--){
            if(pos[i][j]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }
        for(int i=kx,j=ky;i>=0 && j<n;i--,j++){
            if(pos[i][j]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }
        for(int i=kx,j=ky;i>=0 && j>=0;i--,j--){
            if(pos[i][j]){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
                break;
            }
        }
        return ans;
    }
}