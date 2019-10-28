
class Solution {
    public int reverse(int x) {
        int rev = 0, sign = (x & 0x80000000);
        x = Math.abs(x);
        while(x != 0) {
            int digit = x%10;
            x=x/10;
            if (digit > 0 && rev > (Integer.MAX_VALUE-digit)/10 || digit < 0 && rev < (Integer.MIN_VALUE - digit)/10) {
                return 0; //it was overflow
            }
            rev = rev*10+digit;
        }
        return sign == 0? rev: -rev;
    }
}