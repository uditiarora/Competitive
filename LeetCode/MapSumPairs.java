class MapSum {
    Map<String, Integer> map = null;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String key : map.keySet()) {
            if(isPrefix(prefix, key))
                sum += map.get(key);
        }
        return sum;
    }
    private boolean isPrefix(String prefix, String word){
        if(prefix == null) return true;
        if(word == null) return false;
        if(prefix.length() > word.length()) return false;
        
        String substring = word.substring(0, prefix.length());
        return substring.equals(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */