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
    static int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i=0;
        return build(preorder,inorder,0,preorder.length-1);
    }
    
    public TreeNode build(int[] pre, int[] in,int l, int r){
        if(l>r){
            return null;
        }
        TreeNode root = new TreeNode(pre[i++]);
        if(l==r){
            return root;
        }
        
        int val = root.val;
        int index = l;
        for(int j=l;j<=r;j++){
            if(in[j] == val){
                index = j;
                break;
            }
            
        }
        
        root.left = build(pre,in,l,index-1);
        root.right = build(pre,in,index+1,r);
        return root;
        
    }
    
}