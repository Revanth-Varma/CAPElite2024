

//User function Template for Java

/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        if(node==null){
            return 0;
        }
        int left = height(node.left);
        int right =  height(node.right);
        return Math.max(left, right) + 1;
    }
}
