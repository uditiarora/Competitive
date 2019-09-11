class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        util(nums,-1000,0,new ArrayList<Integer>());
        return ans;
    }
    public void util(int[] nums, int last, int l, List<Integer> x){
        
        if(l == nums.length){
            return;
        }
        boolean vis[] = new boolean[201];
        for(int i=l;i<nums.length;i++){
             List<Integer> temp = new ArrayList<Integer>(x);
            
            if(vis[nums[i]+100] == false && nums[i]>=last){
                vis[nums[i]+100] = true;
                temp.add(nums[i]);
                util(nums,nums[i],i+1,temp);
                if(temp.size()>1){
                    ans.add(temp);
                }
            }
        }
       
        
    } 
}