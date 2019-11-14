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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Double> ans = new ArrayList<Double>();
        q.add(root);
        while(!q.isEmpty()){
            
                int n = q.size();
                double sum = 0;
                for(int i=0;i<n;i++){
                    TreeNode temp2 = q.poll();
                    sum += temp2.val;
                    if(temp2.right!=null){
                        q.add(temp2.right);
                    }
                    if(temp2.left!=null){
                        q.add(temp2.left);
                    }
                    
                }
            
                ans.add((double)sum/n);
            
        }
        return ans;
    }
}