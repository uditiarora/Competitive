class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        
        HashMap<String, String> map = new HashMap<String, String>();
        List<String> ans = new ArrayList<String>();
        HashMap<String, Boolean> map2 = new HashMap<String, Boolean>();
        for(int i=0;i<words.length;i++) {
            String temp = words[i];
            for(int j=0;j<=temp.length();j++){
                map.put(temp.substring(0,j), temp);
            }
            map2.put(temp, true);
        }
        
        
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                dfs(i,j, ans, board, map, "", vis, map2);
            }
        }
        return ans;
        
    }
    
    
    public void dfs(int i, int j, List<String> ans, char[][] board, HashMap<String,String> map, String res, boolean vis[][], HashMap<String, Boolean> map2){
        if(i>=board.length || j>= board[0].length || i<0 || j<0 || vis[i][j] == true){
            return;
        }
        vis[i][j] = true;
        
        String temp = res + board[i][j];
        if(map.containsKey(temp)) {
            if(map2.containsKey(temp) && !ans.contains(temp)){
                ans.add(temp);
            }
            dfs(i+1,j, ans, board, map, temp, vis, map2);
            dfs(i-1,j, ans, board, map, temp, vis, map2);
            dfs(i,j+1, ans, board, map, temp, vis, map2);
            dfs(i,j-1, ans, board, map, temp, vis, map2);
        }
        vis[i][j] = false;
    }
}