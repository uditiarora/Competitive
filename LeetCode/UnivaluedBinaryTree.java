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
    public boolean isUnivalTree(TreeNode root) {
        
        if(root==null){
            return true;
        }
        int x = root.val;
        return dfs(root,x);
    }
    
    public boolean dfs(TreeNode root, int val){
        if(root==null){
            return true;
        }
        if(root.val!=val){
            return false;
        }
        return dfs(root.left,val) && dfs(root.right,val);
        
    }
    
}