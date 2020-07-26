class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int j = 0;
        int n = seq.length();
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                j++;
                if(j%2==0){
                    res[i] = 1;
                }
                
            }
            else{
                if(j%2==0){
                    res[i]=1;
                }
                j--;
            }
        }
        return res;
    }
}