/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode ans = null;
    
    public boolean helper(TreeNode root, int p, int q){
        if(root == null){
            return false;
        }
        
        boolean self = (root.val == p || root.val == q);
        
        boolean left = helper(root.left,p,q);
        if(ans != null){
            return true;
        }
        
        
        boolean right = helper(root.right,p,q);
        if(ans != null){
            return true;
        }
        
        if((left && right) || (self && right) || (left && self)){
            ans = root;
        }
        
        return self || left || right;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
        helper(root,p.val,q.val);
        return ans;
        
    }
}