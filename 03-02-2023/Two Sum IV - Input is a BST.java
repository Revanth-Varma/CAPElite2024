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
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int low = 0, high = arr.size()-1;
        while(low<high){
            if(arr.get(low)+arr.get(high)==k){
                return true;
            }
            else if(arr.get(low)+arr.get(high)<k){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
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
