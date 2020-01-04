class Solution {
    
    public int util(int[] arr, int mid) {
        int sum = 0;
        for (int a : arr) {
            sum += a > mid ? mid : a;
        }
        return sum;
    }
    
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int low=0;
        int high = Integer.MAX_VALUE;
    
        int mid = 0;
        while(low<high){
            mid = low + (high-low)/2;
            int sum = util(arr,mid);
            if(sum>=target){
                high = mid;
            }
            else{
                low = mid+1;
            }
            if(diff>Math.abs(target-sum) || (diff == Math.abs(target-sum) && mid<ans)){
                diff = Math.abs(target-sum);
                ans = mid;
            }
        }
        return ans;
    }
}