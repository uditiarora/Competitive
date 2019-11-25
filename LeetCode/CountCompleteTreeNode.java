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
        public int countNodes(TreeNode root) {
        if(root!=null){
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        return 0;
    }
}