class Solution {
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        int len = num1.length + num2.length; 
        int[] arr = new int[len];
        int i = 0, j = 0, k = 0;
        
        while(i < num1.length || j < num2.length) {
            int x = i < num1.length ? num1[i] : Integer.MAX_VALUE;
            int y = j < num2.length ? num2[j] : Integer.MAX_VALUE;
            
            if(x < y) {
                arr[k++] = num1[i++];
            }
            else {
                arr[k++] = num2[j++];
            }
        }
        
        if(len%2 != 0){
            return arr[len/2];
        }
        else return ( arr[len/2] + arr[(len-1)/2] ) / 2.0;
    
    }
}