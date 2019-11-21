class Solution {
    public int minSwap(int[] A, int[] B) {
        int no1=0,yes1=1;
        for(int i=1;i<A.length;i++){
            int no2 = Integer.MAX_VALUE, yes2 = Integer.MAX_VALUE;
            if(A[i-1]<A[i] && B[i-1]<B[i]){
                no2 = Math.min(no2,no1);
                yes2 = Math.min(yes2,yes1+1);
            }
            if(A[i-1]<B[i] && B[i-1]<A[i]){
                no2 = Math.min(no2,yes1);
                yes2 = Math.min(yes2,no1+1);
            }
            no1 = no2;
            yes1 = yes2;
        }
        return Math.min(no1,yes1);

    }
}