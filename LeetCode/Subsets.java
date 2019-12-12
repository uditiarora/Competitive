class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> r = new ArrayList();
        find(r, nums, 0, new ArrayList());
        return r;
    }

    
    void find(List<List<Integer>> r, int[] nums, int pos, List<Integer> cur)
    {
        if (pos == nums.length)
        {
            r.add(new ArrayList(cur));
            return;
        }
        
        // skip this number
        find(r, nums, pos + 1, cur);
        
        // add this number
        int n = cur.size();
        cur.add(nums[pos]);
        find(r, nums, pos + 1, cur);
        cur.remove(n);
    }
}