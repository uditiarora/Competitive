class Solution {
    boolean answer = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        dfs(s, wordDict, 0, visited);
        return answer;
    }
    
    public void dfs(String s, List<String> wordDict, int index, boolean[] visited) {
        if (index == s.length()) {
            answer = true;
            return;
        }
                
        for (int i = 0; i < wordDict.size(); i++) {
            String substr = wordDict.get(i);
            if (!s.substring(index).startsWith(substr) 
                || visited[index + substr.length() - 1]) continue;
            dfs(s, wordDict, index + substr.length(), visited);
            visited[index + substr.length() - 1] = true;
            if (answer) return;
        }
    }
}