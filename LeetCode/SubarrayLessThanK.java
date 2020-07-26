class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int res = 1;
        int ans=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            res = res * nums[i];
            while(res >= k){
                res = res/nums[j++];
            }
            ans = ans + i - j + 1;
        }
        return ans;
    }
}