class Solution {
    
    public int util(int[] dp){
        int l = dp.length;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        int ans = 0;
        while(i<l){
            if(s.isEmpty() || dp[s.peek()]<=dp[i]){
                s.push(i++);
            }
            else{
                int t = dp[s.pop()];
                int temp = t * i;
                if(!s.isEmpty()){
                    temp = t * (i - s.peek() - 1);
                }
                ans = Math.max(ans,temp);
            }
        }
        
        while(!s.isEmpty()){
            int t = dp[s.pop()];
            int temp = t * i;
                if(!s.isEmpty()){
                    temp = t * (i - s.peek() - 1);
                }
                ans = Math.max(ans,temp);
        }
        return ans;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        if(m==0){
            return 0;
        }
        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j] - '0';
        }
        ans = Math.max(ans,util(dp[0]));
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = dp[i-1][j] + 1;
                }
            }
            ans = Math.max(ans,util(dp[i]));
        }
        return ans;
    }
}