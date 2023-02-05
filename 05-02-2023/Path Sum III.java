/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        helper(root, targetSum, 0);
        pathSum(root.left,targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    public void helper(TreeNode node, int target, long currSum){
        if(node == null){
            return;
        }
        currSum += node.val;
        if(currSum == target){
            count++;
        }
        helper(node.left, target, currSum);
        helper(node.right, target, currSum);
    }
}
