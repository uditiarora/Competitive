class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        if(worker == null || difficulty == null || profit == null || profit.length==0) {
            return 0;
        }
        int n = profit.length;
        int[] p = new int[(int)(1e5+1)];
        for(int i=0;i<n;i++){
            p[difficulty[i]] = p[difficulty[i]] > profit[i] ?  p[difficulty[i]] : profit[i];
            
        }
        for(int i=1;i<p.length;i++){
            p[i] = p[i] > p[i-1] ? p[i] : p[i-1];
            
        }
        int cnt = 0;
        for(int i=0;i<worker.length;i++){
            cnt+=p[worker[i]];
        }
        return cnt;
    }
}