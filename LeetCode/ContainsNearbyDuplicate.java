class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<Integer,Integer>();
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if(m.containsKey(nums[i])){
                int temp = m.get(nums[i]);
                if(i-temp<=k){
                    return true;
                }
                
            }   
            m.put(nums[i],i);
            
        }
        return false;
    }
}