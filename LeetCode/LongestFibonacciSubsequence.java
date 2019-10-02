class Solution {
    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer, Boolean> m = new HashMap<Integer, Boolean>();
        int n = A.length;
        int ans = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i=0;i<n;i++){
            m.put(A[i],true);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a = A[i];
                int b = A[j];
                int c = A[i] + A[j];
                int l = 2;
                while(m.containsKey(c)){
                    a = b;
                    b = c;
                    c = a + b;
                    ans = Math.max(ans, ++l);
                }
            }
        }
        if(ans<=2){
            return 0;
        }
        return ans;
    }
}