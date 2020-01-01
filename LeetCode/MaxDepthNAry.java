/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    int max = 0;
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        
        helper(root);
        return max + 1;
    }
    
    public int helper(Node root) {
        if(root == null){
            return 0;
        }
        
        int curMax = 0;
        for(Node node: root.children){
            curMax = Math.max(helper(node), curMax);
        }
        max = Math.max(max, curMax);
        return 1+ curMax;
    }
}