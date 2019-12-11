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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return createTrees(0, n-1);
    }
    
    public List<TreeNode> createTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftTree = createTrees(start, i-1);
            List<TreeNode> rightTree = createTrees(i+1, end);
            for(int j=0; j<leftTree.size(); j++){
                for(int k=0; k<rightTree.size(); k++){
                    TreeNode root = new TreeNode(i+1);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }
}