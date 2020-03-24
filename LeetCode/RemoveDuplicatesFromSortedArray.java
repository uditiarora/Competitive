class Solution {
    public int removeDuplicates(int[] nums) {
        int first=0, second=0;
        int n = nums.length;
        int temp=0;
        for(int i=0;i<n;i++){
            if(i<n-1 && nums[i]==nums[i+1]){
                temp=nums[i];
                nums[first] = temp;
                nums[first+1]=temp;
                first += 2;
            }
            else{
                nums[first] = nums[i];
                first++;
            }
            while(i<n-1 && nums[i]==nums[i+1]){
                i++;
            }
            
        }
        return first;
    }
}