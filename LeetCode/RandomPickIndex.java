class Solution {

     int[] nums;
    ArrayList<Integer> indexes;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        indexes = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target)
                indexes.add(i);
        }
        
        return indexes.get((int)(Math.random() * indexes.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */