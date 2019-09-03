class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = n-1;
            int sum = nums[i] + nums[l] + nums[r];
            while(l<r){
                sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    
                    ans.add(li);
                    int lv = nums[l];
                    int rv = nums[r];
                    
                    l++;
                    r--;
                    while(l<r && lv == nums[l]) l++;
                    while(l<r && rv == nums[r]) r--;
                }
                else if(sum>0){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return ans;
    }
}