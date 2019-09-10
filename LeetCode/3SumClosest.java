class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                int temp = nums[left]+nums[right]+nums[i];
                int temp2 = Math.abs(temp-target);
                if(diff>temp2){
                    ans = temp;
                    diff = temp2;
                }
                if(temp<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}