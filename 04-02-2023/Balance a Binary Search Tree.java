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
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return toBST(0, arr.size()-1);
    }
    public TreeNode toBST(int low, int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = toBST(low, mid-1);
        node.right = toBST(mid+1, high);
        return node;
    }
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        arr.add(node.val);
        inorder(node.right);
    }
}
