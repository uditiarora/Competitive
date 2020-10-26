class Solution {
    String S;
    String maxString;
    int n;
    public String longestDupSubstring(String S) {
        this.S = S;
        maxString = "";
        n = S.length();
        int s = 0, e = S.length();
        while(s<=e){
            int m = s+ (e-s)/2;
            if(window(m)){
                s = m+1;
            }else
                e = m-1;
        }
        return maxString;
    }
    
    public boolean window(int size){
        if(size == 0)
            return false;
        //long h = (long)Math.pow(26, size-1); wrong answer if this is used
        long h = 1;
        for(int i =0; i<size-1; i++)
            h*=26;
        long hash = 0;
        for(int i =0; i<size; i++){
            hash = hash*26+ S.charAt(i)-'a';
        }
        Set<Long> set = new HashSet();
        set.add(hash);
        for(int i = 0; i+size <n; i++){
            hash = (hash - (S.charAt(i)-'a')*h)*26 + S.charAt(i+size)-'a';
            if(set.contains(hash)){
                maxString = S.substring(i+1,i+size+1);
                return true;
            }else
                set.add(hash);
        }
        return false;
    }
}