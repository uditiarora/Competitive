class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> m = new HashMap();
        for(int i:nums){
            if(m.getOrDefault(i,0)==0)
                m.put(i,m.getOrDefault(i,0)+1);
            else
                return true;
        }
        return false;
    }
}