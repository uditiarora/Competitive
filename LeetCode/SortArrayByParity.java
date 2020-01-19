class Solution {
    public int[] sortArrayByParity(int[] A) {
        int second = A.length - 1, i=0;
        while(i < A.length && i < second){
            if(A[i]%2 == 1){
                int temp = A[i];
                A[i] = A[second];
                A[second] = temp;
                second--;
                i--;
            }
            i++;
            
        }
        return A;
    }
}