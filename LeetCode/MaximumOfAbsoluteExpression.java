class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int best = Integer.MIN_VALUE;
        
        int min; 
        int max;
        
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            min = Math.min(min,arr1[i] + arr2[i] + i);
            max = Math.max(max,arr1[i] + arr2[i] + i);
        }
        best = Math.max(best, max-min);
        
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            min = Math.min(min,arr1[i] - arr2[i] + i);
            max = Math.max(max,arr1[i] - arr2[i] + i);
        }
        best = Math.max(best, max-min);
        
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            min = Math.min(min,-arr1[i] + arr2[i] + i);
            max = Math.max(max,-arr1[i] + arr2[i] + i);
        }
        best = Math.max(best, max-min);
        
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            min = Math.min(min,-arr1[i] - arr2[i] + i);
            max = Math.max(max,-arr1[i] - arr2[i] + i);
        }
        best = Math.max(best, max-min);
        
        return best;
    }
}