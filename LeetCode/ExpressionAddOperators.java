class Solution {
private Set<Character> ops = new HashSet<>(Arrays.asList('+', '-', '*', '.'));

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.isEmpty()) return res;
		if (target <= Integer.MIN_VALUE) return res;
        backtrack(num, target, 1, 0, 1, num.charAt(0)-'0', '+', '*', ""+num.charAt(0), res);
        return res; 
    }
    
    
    public void backtrack(String num, int target, int index, long n1, long n2, long n3, char op1, char op2, String temp, List<String> res) {

        if (index == num.length()) {
            if (evaluate(n1, n2, n3, op1, op2) == target) res.add(temp);
            return;
        }

        int n = num.charAt(index)-'0';
        for (char op : ops) {
            if (op == '.') {
                if (n3 != 0) backtrack(num, target, index+1, n1, n2, n3*10+n, op1, op2, temp+n, res);
            }
            else if (op1 == '*') backtrack(num, target, index+1, evaluate(n1, n2, op1), n3, n, op2, op, temp+op+n, res);
            else if (op2 == '*') backtrack(num, target, index+1, n1, evaluate(n2, n3, op2), n, op1, op, temp+op+n, res);
            else backtrack(num, target, index+1, evaluate(n1, n2, op1), n3, n, op2, op, temp+op+n, res);
        }
    }

    public long evaluate(long n1, long n2, char op) {
        if (op == '+') return n1+n2;
        if (op == '-') return n1-n2;
        return n1*n2;
    }

    public long evaluate(long n1, long n2, long n3, char op1, char op2) {
        if (op1 == '*') return evaluate(n1*n2, n3, op2);
        if (op2 == '*') return evaluate(n1, n2*n3, op1);
        return evaluate(evaluate(n1, n2, op1), n3, op2);
    }
    
}