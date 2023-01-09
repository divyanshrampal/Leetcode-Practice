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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        
        while(root != null)
        {
            
            if(root.left == null)
            {
                 // root can be visited only once
                l.add(root.val);
                root = root.right;
            }    
            
            else 
            {
                TreeNode rootLeft = root.left;
                
                while(rootLeft.right != null && rootLeft.right != root)
                {
                    rootLeft = rootLeft.right; 
                }  
                
                if(rootLeft.right == null){ // first visit
                    
                    l.add(root.val);
                    rootLeft.right = root;  // connect
                    root = root.left;
                }    
                else if(rootLeft.right == root)
                {
                    // second visit
                    rootLeft.right = null; // disconnect
                    root = root.right;
                    
                }    
                
            }    
            
            
        }    
        
        return l;
    }
}