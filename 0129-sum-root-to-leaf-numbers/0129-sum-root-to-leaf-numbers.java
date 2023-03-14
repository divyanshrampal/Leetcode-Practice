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
    
    int total; 
    
    public void sumNumbersHelper(TreeNode root, int sum){
        
        if(root == null){
            return; 
        }
        
        sum = sum*10 + root.val;
        
        if(root.left == null && root.right == null){
            total += sum;
            return;
        }
        
        sumNumbersHelper(root.left, sum);
        sumNumbersHelper(root.right, sum);
        
    }
    public int sumNumbers(TreeNode root) {
        
        total = 0;
        
        sumNumbersHelper(root, 0);
        
        return total;
        
       
        
    }
}