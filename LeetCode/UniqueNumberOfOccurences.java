class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i],m.get(arr[i]) + 1);
            }
            else{
                m.put(arr[i],1);
            }
        }
        HashMap<Integer,Boolean> m2 = new HashMap<Integer, Boolean>();
        Set<Integer> s = m.keySet();
        for(int i : s){
            if(m2.containsKey(m.get(i))){
                return false;
            }
            m2.put(m.get(i),true);
        }
        return true;
    }
}s