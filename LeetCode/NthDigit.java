class Solution {
    public int findNthDigit(int n) {
        int temp = 9;
        int count = 1;
        while(n - temp>0){
            n -= temp;
            count++;
            temp = (count) * 9 * ((int)Math.pow(10,count-1));
            if(temp<0) break;
        }
        
        int temp2 = (int)Math.pow(10,count-1) + (n-1)/count;
        return String.valueOf(temp2).charAt((n-1)%count) - '0';
    }
}