class Solution {
    
    List<List<Integer>> lists; 
    
    private void helper(int[][] graph, int curr, List<Integer> list) {
        list.add(curr); 
        if(curr == graph.length-1) {
            lists.add(new ArrayList<Integer>(list)); 
        }
        for(int neighbor : graph[curr]) {
            helper(graph, neighbor, list);         
        }
        list.remove(list.size()-1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>(); 
        lists = new ArrayList<>();
        helper(graph, 0, list); 
        return lists; 
    }
}