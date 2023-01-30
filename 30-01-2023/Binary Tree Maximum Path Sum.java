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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxVal(root);
        return max;
    }
    public int maxVal(TreeNode node){
        if(node==null){
            return 0;
        }
        int lSum = maxVal(node.left);
        int rSum = maxVal(node.right);
        if(lSum<0){
            lSum = 0;
        }
        if(rSum<0){
            rSum = 0;
        }
        if(lSum+rSum+node.val>max){
            max = lSum+rSum+node.val;
        }
        return Math.max(lSum,rSum)+node.val;

    }
}
