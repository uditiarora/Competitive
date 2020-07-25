class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<Integer>();
        int[] ans = new int[T.length];
        for(int i=0;i<T.length;i++){
            if(s.isEmpty() || T[s.peek()]>=T[i]){
                s.push(i);
            }
            else{
                while(!s.isEmpty() && T[s.peek()]<T[i]){
                    int temp = s.pop();
                    ans[temp] = i-temp;
                }
                s.push(i);
            }
        }
        return ans;
    }
}