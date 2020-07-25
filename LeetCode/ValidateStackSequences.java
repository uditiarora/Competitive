class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();
        
        int n = pushed.length;
        int j=0;
        for(int i=0;i<n;i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[j]){
                s.pop();
                j++;
            }
        }
        return j==n;
    }
}