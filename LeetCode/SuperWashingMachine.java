class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0,temp=0;
        for(int i=0;i<n;i++){
            sum += machines[i];
        }
        if(sum%n != 0){
            return -1;
        }
        int t = sum/n;
        int ans = 0;
        for(int i=0;i<n;i++){
            temp += machines[i];
            
            ans = Math.max(ans, Math.abs(temp - (i+1)*t));
            
            ans = Math.max(ans, machines[i] - t);
        }
        return ans;
        
    }
}