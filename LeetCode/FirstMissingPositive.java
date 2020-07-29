class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i] = Integer.MAX_VALUE;
            }
            
        }
        for(int i=0;i<n;i++){
            int temp = Math.abs(nums[i]);
            if(temp != Integer.MAX_VALUE && temp<=n){
                nums[temp-1] = Math.abs(nums[temp-1]) * -1;
            } 
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }
}