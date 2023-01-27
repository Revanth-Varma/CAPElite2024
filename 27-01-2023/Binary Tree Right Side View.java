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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int rh = 0;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
                rh = curr.val;
            }
            result.add(rh);
        }
        return result;
    }
}
