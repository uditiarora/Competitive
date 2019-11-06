class Solution {
    public int minIncrementForUnique(int[] A) {
        int n = A.length,temp=0;
        int ans = 0;
        int count[] = new int[100000];
        for(int i=0;i<n;i++){
            count[A[i]]++;
        }
        for(int i=0;i<=90000;i++){
            if(count[i]>1){
                temp += count[i] - 1;
                ans -= i*(count[i]-1);
            }
            else if(temp>0 && count[i]==0){
                temp--;
                ans += i;
            }
        }
        return ans;
    }
}