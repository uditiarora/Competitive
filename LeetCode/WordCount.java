class Solution {
    public boolean wordPattern(String pattern, String str) {
        String arr[] = str.split(" ");
        int m = pattern.length();
        int n = arr.length;
        if(m!=n){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character,String>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(pattern.charAt(i))){
                String temp = map.get(pattern.charAt(i));
                if(!arr[i].equals(temp)){
                    return false;
                }
                
            }
            else{
                if(map.containsValue(arr[i])){
                    return false;
                }
                map.put(pattern.charAt(i),arr[i]);
            }
            
        }
        return true;
    }
}