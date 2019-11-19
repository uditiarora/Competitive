class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrackSearch(s, new LinkedList<>(), 0);
        return res;
    }
    
    void backtrackSearch(String s, LinkedList<String> sol, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<>(sol));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < s.length(); i += 1) {
                char c = s.charAt(i);
                sb.append(c);
                if (isPalindrome(sb)) {
                    sol.add(sb.toString());
                    backtrackSearch(s, sol, i + 1);
                    sol.removeLast();
                }   
            }
        }
    }
    
    boolean isPalindrome(StringBuilder sb) {
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}