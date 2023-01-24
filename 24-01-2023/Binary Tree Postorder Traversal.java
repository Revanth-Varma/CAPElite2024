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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        traversal(res, root);
        return res;
    }
    public void traversal(ArrayList<Integer> res , TreeNode node){
        if(node!=null){
            traversal(res, node.left);
            traversal(res, node.right);
            res.add(node.val);
        }
        else{
            return;
        }
    }
}
