public class Solution {
    List<Integer> ans = new ArrayList<>();
    Integer pre;
    int maxFreq = 0, curFreq = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) res[i] = ans.get(i);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && root.val == pre) {
            curFreq++;
        } else {
            curFreq = 1;
        }
        if (curFreq == maxFreq) {
            ans.add(root.val);
        } else if (curFreq > maxFreq) {
            maxFreq = curFreq;
            ans = new ArrayList<>();
            ans.add(root.val);
        } 

        pre = root.val;
        inorder(root.right);
    }
}
