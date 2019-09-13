class Solution {
    public int countTriplets(int[] A) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < A.length;j++){
                
                int val = A[i] & A[j];
                
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        for(Integer key : map.keySet()){
             for(int i = 0;i < A.length;i++){
                 if((key&A[i]) == 0) count+= map.get(key);
             }
        }
       
        return count;
    }
}