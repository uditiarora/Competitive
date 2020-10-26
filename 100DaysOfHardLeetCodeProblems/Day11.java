class Solution {
    public int minDistance(String word1, String word2) {
        Integer [][]dp = new Integer[word1.length()+1][word2.length()+1];
        return minDistance(word1, word2, dp, word1.length(),word2.length());
    }
    
    private int minDistance(String w1, String w2, Integer [][]dp, int i, int j){
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        if(i == 0 || j == 0){
            return i==0 ? j : i;
        }
        
        if(w1.charAt(i-1) == w2.charAt(j-1)){
            dp[i][j] = minDistance(w1, w2, dp, i-1, j-1);
        }else{
            dp[i][j] = Math.min(1 + minDistance(w1, w2, dp, i, j-1), Math.min(1 + minDistance(w1, w2, dp, i-1, j), 1 + minDistance(w1, w2, dp, i-1, j-1)));
        }
        
        return dp[i][j];
    }
}