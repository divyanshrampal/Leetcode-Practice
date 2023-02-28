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
    
    
    public String solve(TreeNode root, Map<String, Integer> mp, List<TreeNode> result){
        
        if(root == null){
            return "N";
        }
        String s = String.valueOf(root.val) + "," + solve(root.left, mp, result) + "," + solve(root.right, mp, result);
        
        if(mp.containsKey(s) && mp.get(s) == 1){
            result.add(root);
        }
        
         mp.put(s, mp.getOrDefault(s, 0) + 1);
        
        return s;
        
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        List<TreeNode> result = new ArrayList<>();
        
        Map<String, Integer> mp = new HashMap<>();
        
        String s = solve(root, mp, result);
        
        return result;
        
    }
}