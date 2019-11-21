class Solution {
    public boolean canReorderDoubled(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i] < 0){
                A[i] *= -1;
            }
        }
        int[] count = new int[100001];
        for(int a : A){
            count[a]++;
        }
        for(int i = 0; i <= 100000; i++){
            if(count[i] > 0){
                int key = 2 * i;
                if(2 * i > 100000){
                    return false;
                }
                count[2 * i] -= count[i];
                count[i] = 0;
            }
        }
        int sum = 0;
        for(int c : count){
            sum += c;
        }
        return sum == 0;
    }
}