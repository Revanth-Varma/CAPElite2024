/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        if(root == null){
            return "";
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr==null){
                res.append("X ");
                continue;
            }
            res.append(curr.val+" ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==""){
            return null;
        }
        String[] inp = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(inp[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int i = 1;
        while(i<inp.length){
            TreeNode curr = queue.poll();
            if(!inp[i].equals("X")){
                curr.left = new TreeNode(Integer.parseInt(inp[i]));
                queue.offer(curr.left);
            }
            i++;
            if(!inp[i].equals("X")){
                curr.right = new TreeNode(Integer.parseInt(inp[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
