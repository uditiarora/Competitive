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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a = Math.min(p.val,q.val);
        int b = Math.max(p.val,q.val);
        return lca(root,a,b);
    }
    
    public TreeNode lca(TreeNode root, int a, int b){
        if(root.val>a && root.val<b){
            return root;
        }
        else if(root.val> b){
            return lca(root.left, a,b);
        }
        else if(root.val<a){
            return lca(root.right,a,b);
        }
        return root;
    }
}