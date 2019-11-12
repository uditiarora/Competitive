class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> chosen = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        permuteUnique(nums,chosen,res,visited);
        return res;
    }
    
        public void permuteUnique(int[] nums,List<Integer> chosen,List<List<Integer>> res, boolean visited[] ) {
            if(chosen.size() == nums.length){
                res.add(new ArrayList<>(chosen));
                return;
            }
            Set<Integer> unique = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if(!visited[i] && unique.add(nums[i])){
                     chosen.add(nums[i]);
                     visited[i] = true;
                     permuteUnique(nums,chosen,res,visited);
                     visited[i] = false;
                     chosen.remove(chosen.size()-1);
                }

                 
            }
        }

}