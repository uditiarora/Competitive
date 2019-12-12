class Solution {
    private boolean util(int[] weights, int mid, int D){
        int index = 0;
        int count = 0;
        while(index < weights.length){
            int curShip = 0;
            while(index < weights.length && curShip + weights[index] <= mid){
                curShip += weights[index++];
            }
            count++;
            if(count > D) return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int n = weights.length;
        for(int i=0;i<n;i++){
            sum += weights[i];
        }
        
        int low = 1, high = sum, mid=0;
        int ans = 0;
        while(low<high){
            mid = low + (high-low)/2;
            if(util(weights, mid, D)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
        
        
    }
    
}