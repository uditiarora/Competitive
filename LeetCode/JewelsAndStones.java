class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Boolean> map = new HashMap<Character, Boolean>();
        int n = J.length();
        for(int i=0;i<n;i++){
            map.put(J.charAt(i),true);
        }
        n = S.length();
        int count = 0;
        for(int i=0;i<n;i++){
            if(map.containsKey(S.charAt(i))){
                count++;
            }
        }
        return count;
    }
}