class Solution {
    public  int nPr(int n, int r){
        int ans = 1;
        if(r > 9) return 0;
        for(int i = n; i > n - r && i >= 1; --i){
            ans *= i;
        }
        return ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
      int ans = 1;
        for(int i = 0; i < n; ++i){
            ans += 9*nPr(9, i);
        }
        return ans;   
    }
}