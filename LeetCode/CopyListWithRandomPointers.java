/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    HashMap<Node, Node> map = new HashMap();
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        if (map.containsKey(head)) {
            return map.get(head);
        }
        
        Node newHead = new Node();
        map.put(head, newHead);
        newHead.val = head.val;
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return newHead;
    }
}