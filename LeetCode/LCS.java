class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        int ans = 1;
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            m.put(nums[i],1);
        }
        for(int i=0;i<n;i++){
            if(!m.containsKey(nums[i] - 1)){
                if(m.containsKey(nums[i] + 1)){
                    int temp = 1;
                    int temp2 = nums[i]+1;
                    while(m.containsKey(temp2)){
                        temp++;
                        temp2++;
                    }
                    ans = Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
}