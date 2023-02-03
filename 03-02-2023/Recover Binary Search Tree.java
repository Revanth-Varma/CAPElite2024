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
    TreeNode node1 = null, node2 = null, prev = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    public void helper(TreeNode curr){
        if(curr==null){
            return;
        }
        helper(curr.left);
        if(prev!=null && curr.val<prev.val){
            if(node1==null){
                node1 = prev;
            }
            node2 = curr;
        }
        prev = curr;
        helper(curr.right);
    }
}
