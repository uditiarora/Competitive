class Solution {
    private int getCommonLen(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n = Math.min(n1, n2);
        
        for (int i = n; i >= 0; i--) {
            if (s1.substring(n1-i, n1).equals(s2.substring(0, i))) {
                return i;
            }
        }
        
        return 0;
    }
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        if(n==1){
            return A[0];
        }
        String dp[][] = new String[n][(1<<n)];
        int len[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                len[i][j] = getCommonLen(A[i],A[j]);
                len[j][i] = getCommonLen(A[j],A[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        String minStr = null;
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                if((i & (1<<j)) == 0){
                    continue;
                }
                if(i == (1<<j)){
                    dp[j][i] = A[j];
                    continue;
                }
                int state = i ^ (1 << j);
                int cur = Integer.MAX_VALUE;
                String curStr = null;
                for (int x = 0; x < n; x++) {
                    if (x != j && (i & (1 << x)) > 0 
                        && dp[x][state].length() + A[j].length() - len[x][j] < cur) {
                        cur = dp[x][state].length() + A[j].length() - len[x][j];
                        curStr = dp[x][state] + A[j].substring(len[x][j]);
                    }
                }
                dp[j][i] = curStr;
                
                if (i == ((1<<n) - 1)) {
                    if (min > dp[j][i].length()) {
                        min = dp[j][i].length();
                        minStr = dp[j][i];
                    }
                }
                
            }
        }
        return minStr;
        
    }
}