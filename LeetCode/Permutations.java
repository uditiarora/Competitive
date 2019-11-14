class Solution 
{
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        helper(new ArrayList<>(), ans, marked, nums);
        return ans;
    }
    
    private void helper(List<Integer> list, List<List<Integer>> ans, 
                       boolean[] marked, int[] nums)
    {
        if(list.size() == nums.length) ans.add(new ArrayList<>(list));
        for(int i = 0; i < nums.length; i++)
        {
            if(marked[i]) continue;
            list.add(nums[i]);
            marked[i] = true;
            helper(list, ans, marked, nums);
            list.remove(list.size()-1);
            marked[i] = false;
        }
    }
}