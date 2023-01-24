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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    public void helper(ArrayList<Integer> res, TreeNode node){
        if(node==null){
            return;
        }
        res.add(node.val);
        helper(res, node.left);
        helper(res, node.right);
    }
}
