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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(root,ans,target,K);
        return ans;
    }
    public int dfs(TreeNode root, List<Integer> ans,TreeNode target, int k){
        if(root == null){
            return -1;
        }
        if(root == target){
            util(root,ans,0,k);
            return 1;
        }
        int l = dfs(root.left,ans,target,k);
        int r = dfs(root.right,ans,target,k);
        if(l!=-1){
            if(l==k){
                ans.add(root.val);
            }
            util(root.right,ans,l+1,k);
            return l+1;
        }
        else if(r!=-1){
            if(r==k){
                ans.add(root.val);
            }
            util(root.left,ans,r+1,k);
            return r+1;
        }
        else{
            return -1;
        }
    }
    public void util(TreeNode root,List<Integer> ans, int i,int k){
        if(root==null){
            return ;
        }
        if(i==k){
            ans.add(root.val);
        }
        else{
            util(root.right,ans,i+1,k);
            util(root.left,ans,i+1,k);
        }
    }
    
}