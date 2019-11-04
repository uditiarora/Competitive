class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false)
                return false;
        }
        return true;
    }
    
    public void dfs(List<List<Integer>> rooms, int r, boolean[] visited){
        if(visited[r])return;
        visited[r]=true;
        for(int k=0;k<rooms.get(r).size();k++){
            int nextRoom=rooms.get(r).get(k);
            dfs(rooms,nextRoom, visited);
        }
    }
}