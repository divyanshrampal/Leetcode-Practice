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
    
    int index;
    
    public TreeNode bstFromPreorderHelper(int[] preorder, int leftRange, int rightRange){
        
        if(index >= preorder.length || preorder[index] < leftRange || preorder[index] > rightRange){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[index++]);
        
        node.left = bstFromPreorderHelper(preorder, leftRange, node.val);
        node.right = bstFromPreorderHelper(preorder, node.val, rightRange);
        
        return node;
        
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        
        int lr = -(int)1e9 - 1;
        int rr = (int)1e9 + 1;
        index = 0;
        
        return bstFromPreorderHelper(preorder, lr, rr);
        
    }
}