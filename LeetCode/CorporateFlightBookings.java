class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int dp[] = new int[n];
        for(int i=0;i<bookings.length;i++){
            int a = bookings[i][0] - 1;
            int b = bookings[i][1] - 1;
            int k = bookings[i][2];
            dp[a] += k;
            if(b+1<n){
                dp[b+1] -= k;    
            }
            
        }
        for(int i=1;i<n;i++){
            dp[i] += dp[i-1];
        }
        return dp;
    }
}