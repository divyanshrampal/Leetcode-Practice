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
    
    
    public void rootToNode(TreeNode root, TreeNode x, List<TreeNode> l){
        if(root == null){
            return;
        }
        
        l.add(root);
        
        if(root.val == x.val){
            return;
        }
        
        if(x.val > root.val){
            rootToNode(root.right, x, l);
        }
        else{
            rootToNode(root.left, x, l);
        }
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        
        rootToNode(root, p, l1);
        rootToNode(root, q, l2);
        
        
        int i = 0, j = 0;
        
        while(i < l1.size() && j < l2.size() && l1.get(i) == l2.get(j)){
            i++;
            j++;
        }
        
        return l1.get(i-1);
        
    }
}