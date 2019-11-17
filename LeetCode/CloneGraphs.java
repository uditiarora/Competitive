/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        clone(nodeMap, node);
        return nodeMap.get(node);
    }
    
    private Node clone(Map<Node, Node> nodeMap, Node node)
    {
        if(nodeMap.containsKey(node)) return nodeMap.get(node);
        Node copy = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, copy);
        for(Node child : node.neighbors)
        {
            copy.neighbors.add(clone(nodeMap, child));
        }
        return copy;
    }
}