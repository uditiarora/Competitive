class Solution {
   
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();        
        Arrays.fill(res, -1);
        
        for(int i = 0; i < 2 * len; i ++){
            int curIndex = i % len;
            int cur = nums[curIndex];
            while(!stack.isEmpty() && nums[stack.peek()] < cur){ 
                res[stack.pop()] = cur;
            }
            if(i < len){
                stack.push(curIndex); 
            }
        } 
        
        return res;
    }
}