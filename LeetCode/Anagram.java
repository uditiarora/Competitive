class Solution {
    public int minSteps(String s, String t) {
        int[] abc = new int[26];
        for (char c : s.toCharArray()) abc[c-'a']++;
        for (char c : t.toCharArray()) abc[c-'a']--;
        int ans=0;
        for (int num : abc) ans+= Math.abs(num);
        return ans/2;
    }
}