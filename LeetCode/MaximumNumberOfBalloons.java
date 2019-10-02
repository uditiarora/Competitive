class Solution {
    public int maxNumberOfBalloons(String text) {
        int ans = Integer.MAX_VALUE;
        int n = text.length();
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for(int i=0;i<n;i++){
            if(m.containsKey(text.charAt(i))){
                m.put(text.charAt(i),m.get(text.charAt(i)) + 1);
            }
            else{
                m.put(text.charAt(i),1);
            }
        }
        if(m.containsKey('b')){
            int temp = m.get('b');
            ans = Math.min(temp,ans);
        }
        else{
            return 0;
        }
        if(m.containsKey('a')){
            int temp = m.get('a');
            ans = Math.min(temp,ans);
        }
        else{
            return 0;
        }
        if(m.containsKey('l')){
            int temp = m.get('l');
            ans = Math.min(temp/2,ans);
        }
        else{
            return 0;
        }
        if(m.containsKey('o')){
            int temp = m.get('o');
            ans = Math.min(temp/2,ans);
        }
        else{
            return 0;
        }
        if(m.containsKey('n')){
            int temp = m.get('n');
            ans = Math.min(temp,ans);
        }
        else{
            return 0;
        }
        return ans;
    }
    
}