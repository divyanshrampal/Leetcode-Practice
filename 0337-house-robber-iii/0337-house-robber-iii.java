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
    
    class housePair{
        int withRob = 0;
        int withoutRob = 0;
    }
    
    public housePair solve(TreeNode root){
        if(root == null){
            return new housePair(); 
        }
        
        housePair left = solve(root.left);
        housePair right = solve(root.right);
        
        
        housePair ans = new housePair();
        ans.withRob = left.withoutRob + right.withoutRob + root.val;
        ans.withoutRob = Math.max(left.withRob, left.withoutRob) + Math.max(right.withRob, right.withoutRob);
        
        return ans;
        
        
    }
    public int rob(TreeNode root) {
        housePair solution = solve(root);
        
        return Math.max(solution.withRob, solution.withoutRob);
    }
} 