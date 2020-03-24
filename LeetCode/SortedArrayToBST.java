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
    public TreeNode sortedArrayToBST(int[] nums) {
        return util(nums,0, nums.length-1);
    }
    
    public TreeNode util(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        if(left==right){
            return new TreeNode(nums[left]);
        }
        int mid = left + (right-left)/2;
        TreeNode ans = new TreeNode(nums[mid]);
        ans.left = util(nums, left, mid-1);
        ans.right = util(nums, mid+1, right);
        return ans;
    }
}