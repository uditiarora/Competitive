class Solution {
    public boolean reorderedPowerOf2(int N) {
        int arr[] = count(N);
        for(int i=0;i<31;i++){
            if(Arrays.equals(arr,count(1<<i))){
                return true;
            }
        }
        return false;
        
    }
    public int[] count(int n){
        int[] res = new int[10];
        while(n>0){
            res[n%10]++;
            n = n/10;
        }
        return res;
    }
}