class Solution {
    
    public int trap(int[] height) {
        int len = height.length;
        int[] minBar = new int[len];
        int curMax = -1;
        
        for(int i = 0; i<len; i++){
            curMax = Math.max(curMax,height[i]);
            minBar[i] = curMax;
        }
        curMax = -1;
        int sum = 0;
        for(int i = len-1; i >= 0; i--){
            curMax = Math.max(curMax,height[i]);
            sum += Math.min(curMax, minBar[i]) - height[i];
        }
        return sum;       
    }
}