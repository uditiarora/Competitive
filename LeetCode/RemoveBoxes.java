class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int dp[][][] = new int[100][100][100];
        return util(boxes,dp,0,boxes.length - 1,0);
        
    }
    
    public int util(int[] boxes, int dp[][][], int l, int r,int k){
        if(l>r || k>boxes.length){
            return 0;
        }
        
        if(dp[l][r][k]>0){
            return dp[l][r][k];
            
        }
        
        int r2 = r,k2 = k;
        while(l<r && boxes[r-1] == boxes[r]){
            r--;
            k++;
        }
        dp[l][r][k] = util(boxes,dp,l,r-1,0) + (k+1)*(k+1);
        
        for(int i=l;i<r;i++){
            if(boxes[i] == boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k] , util(boxes,dp,l,i,k+1) + util(boxes,dp,i+1,r-1,0));
            }
        }
        for(int i=1;i<=r-r2;i++){
            dp[l][r+i][k-i] = dp[l][r][k];
        }
        return dp[l][r][k];
    }
}