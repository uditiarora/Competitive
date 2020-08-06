class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet();
        set.add("+");set.add("-");set.add("/");set.add("*");
        Stack<Integer> stack =new Stack();
        int res = 0;
        for(String token : tokens){
            if(set.contains(token)){
                int second = stack.pop();
                int first = stack.pop();
                if(token.equals("+")){
                    res = first+second;
                }
                else if(token.equals("-")){
                    res = first-second;
                }
                else if(token.equals("*")){
                    res = first * second;
                }
                else{
                    res = first/second;
                }
                stack.push(res);
            }
            else{
                stack.push(Integer.valueOf(token));
            }
        }
        
        return stack.pop();
    }
}