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
    
    public void dfsHelper(TreeNode root, StringBuilder ans){
        if(root == null){
            return;
        }
        
        ans.append(String.valueOf(root.val));
        if (root.left == null && root.right == null)
            return;
        ans.append('(');
        dfsHelper(root.left, ans);
        ans.append(')');
        if (root.right != null) {
            ans.append('(');
            dfsHelper(root.right, ans);
            ans.append(')');
        }

    }
    
    public String tree2str(TreeNode root) {
        
        StringBuilder ans = new StringBuilder();
        
        dfsHelper(root, ans);
        return ans.toString();
        
    }
}