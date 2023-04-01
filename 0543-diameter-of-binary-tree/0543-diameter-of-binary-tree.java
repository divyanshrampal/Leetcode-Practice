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
    
    class Pair{
        int diameter;
        int height;
        
        Pair(int diameter, int height){
            this.diameter = 0;
            this.height = 0;
        }
    }
    
    public Pair diameterHelper(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        
        Pair left = diameterHelper(root.left);
        Pair right = diameterHelper(root.right);
        
        int op1 = left.diameter;
        int op2 = right.diameter;
        int op3 = left.height + right.height;
        
        Pair ans = new Pair(0,0);
        ans.diameter = Math.max(op1, Math.max(op2, op3));
        ans.height = Math.max(left.height, right.height) + 1;
        
        return ans;
    }
    
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        return diameterHelper(root).diameter;
        
    }
}