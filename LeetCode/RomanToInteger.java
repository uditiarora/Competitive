class Solution {
    public int convert(char c){
        if(c == 'I'){
            return 1;
        }
        if(c == 'V'){
            return 5;
        }
        if(c == 'X'){
            return 10;
        }
        if(c == 'L'){
            return 50;
        }
        if(c == 'C'){
            return 100;
        }
        if(c == 'D'){
            return 500;
        }
        if(c == 'M'){
            return 1000;
        }
           return 0;
    }
    public int romanToInt(String s) {
        int n = s.length();
        if(n==0){
            return 0;
        }
        int ans = 0;
        int i = 0;
        for(i=0;i<n-1;i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            int t1 = convert(c1);
            int t2 = convert(c2);
            if(t1<t2){
                ans = ans + t2 - t1;
                i++;
            }
            else{
                ans = ans + t1;
            }
        }
        if(i<n){
        ans += convert(s.charAt(n-1));}
        return ans;
    }
}