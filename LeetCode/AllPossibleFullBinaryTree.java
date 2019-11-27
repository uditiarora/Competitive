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
    public List<TreeNode> allPossibleFBT(int N) {
        List[] cache = new List[N + 1];
        cache[1] = Arrays.asList(new TreeNode(0));
        
        return allPossibleFBT(N, cache);
    }
    
    public List<TreeNode> allPossibleFBT(int N, List<TreeNode>[] cache) {
        if (N % 2 == 0) {
            return Collections.emptyList();
        } if (cache[N] != null) {
            return cache[N];
        }
        
        List<TreeNode> result = new ArrayList<>();
        for (int i=1; i< N - 1; i+=2) {
            List<TreeNode> left = allPossibleFBT(i, cache);
            List<TreeNode> right = allPossibleFBT(N - i - 1, cache);
            
            for (int j=0; j<left.size(); j++) {
                for (int k=0; k<right.size(); k++) {
                    TreeNode node = new TreeNode(0);
                    node.left = left.get(j);
                    node.right = right.get(k);
                    result.add(node);
                }
            }
        }
        cache[N] = result;
        return result;
    }
}