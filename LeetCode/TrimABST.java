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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return null;
        }
        TreeNode head = root;
        if(root.val>=L && root.val<=R){
            head.left = trimBST(head.left,L,R);
            head.right = trimBST(head.right,L,R);
        }else{
            if(root.val<L){
                head = root.right;
            }else{
                head = root.left;    
            }
            root=null;
            return trimBST(head,L,R);
        }
        return head;
    }
}