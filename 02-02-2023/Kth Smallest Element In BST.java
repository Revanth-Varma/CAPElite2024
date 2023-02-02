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
    Integer KthMin = null;
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return KthMin;
    }
    public void helper(TreeNode node, int k){
        if(node == null || i==k){
            return;
        }
        helper(node.left, k);
        if(i<k){
            KthMin = node.val;
            i++;
        }
        helper(node.right, k);
    }
}
