class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        
        String ans = num;
        for(int i = 0; i < k; i++) {
            int j = 0;
            while(j < ans.length() - 1) {
                if(ans.charAt(j) <= ans.charAt(j + 1)) j++;
                else break;
            }
            String l = removeLeadingZero(ans.substring(0, j));
            String r = "";
            if(l.length() == 0) r = removeLeadingZero(ans.substring(j + 1));
            else r = ans.substring(j + 1);
            ans = l + r;
        }
        return ans.length() == 0 ? "0" : ans;
    }
    
    public String removeLeadingZero(String s) {
        int j = 0;
        while(j < s.length() && s.charAt(j) == '0') j++;
        return s.substring(j);
    }
}