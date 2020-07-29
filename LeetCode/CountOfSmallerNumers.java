class Solution {
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> t = new ArrayList<Integer>();
        int[] res = new int[nums.length];
        for (int i=nums.length-1; i>=0; i--){
            int left = 0, right = t.size();
            while(left < right){
                int mid = left + (int)((right-left)/2);
                if (t.get(mid) >= nums[i]){
                    right = mid;
                }
                else{
                    left = mid + 1;
                }
            }
            res[i] = right;
            t.add(right, nums[i]);
        }
        ArrayList<Integer> res2 = new ArrayList<Integer>();
        for(int ares: res){
            res2.add(ares);
        }
        return res2;
    }
}