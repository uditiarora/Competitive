class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) 
            return new ArrayList<>();
        int len = s.length();
        List<String> res = new ArrayList<>();
        boolean[] memo = new boolean[len];
        Arrays.fill(memo, true);
        dfs(s, wordDict, res, new StringBuilder(), memo, 0);
        return res;
    }
    private void dfs(String s, List<String> wordDict, List<String> res, StringBuilder sb, boolean[] memo, int index){
        int len = s.length();
        
        if(index == len){
            res.add(sb.toString());
            return;
        }
       
        if(!memo[index]) return;
        
        
         int resultSize = res.size();
         int sbLen = sb.length();
        for(int i = index; i < len; i++){
            String str = s.substring(index, i+1);
            if(wordDict.contains(str)){
                if(sbLen == 0) sb.append(str);
                else sb.append(" " + str);
                dfs(s, wordDict, res, sb, memo, i+1);
                sb.setLength(sbLen);
            }
        }
        if(resultSize == res.size()){
            memo[index] = false;
        }
    }
}