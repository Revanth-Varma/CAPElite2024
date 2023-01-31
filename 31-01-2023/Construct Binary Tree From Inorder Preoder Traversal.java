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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = new TreeNode();
        root = helper(preorder, map, 0, inorder.length-1);
        return root;
    }
    public TreeNode helper(int[] preorder, Map<Integer, Integer> map, int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, map, inStart, map.get(val)-1);
        node.right = helper(preorder, map, map.get(val)+1, inEnd);
        return node;
    }
}
