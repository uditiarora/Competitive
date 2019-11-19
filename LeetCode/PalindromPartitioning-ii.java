class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean pal[][] = new boolean[n+1][n+1];
        int ans[] = new int[n+1];
        for(int i=0;i<n;i++){
            pal[i][i] = true;
        }
        ans[0] = -1;
        for(int i=1;i<=n;i++){
            ans[i] = n-1;
            for(int j=0;j<i;j++){
                if(s.charAt(i-1)==s.charAt(j) && (i<=j+2 || pal[j+1][i-2])){
                    pal[j][i-1] = true;
                    ans[i] = Math.min(ans[i],ans[j] + 1);
                }
            }
        }
        return ans[n];
    }
}