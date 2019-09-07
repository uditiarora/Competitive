class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0;i<n;i++){
            xor = xor ^ nums[i];
        }
        int set_bit = xor & ~(xor-1);
        int a=0,b=0;
        for(int i=0;i<n;i++){
            if((nums[i] & set_bit) > 0){
                a = a ^ nums[i];
            }
            else{
                b = b ^ nums[i];
            }
        }
        int ans[] = new int[2];
        ans[0] = a;
        ans[1] = b;
        return ans;
    }
}