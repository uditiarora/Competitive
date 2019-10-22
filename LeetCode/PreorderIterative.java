/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
		
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
		
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            list.add(cur.val);
        }
        
        return list;
    }
}