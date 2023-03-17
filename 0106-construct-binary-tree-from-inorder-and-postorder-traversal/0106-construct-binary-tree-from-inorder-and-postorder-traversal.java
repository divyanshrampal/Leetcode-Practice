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
    
    HashMap<Integer, Integer> map; 
    int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder)  {
       
      postIndex = postorder.length - 1;
      
      map = new HashMap<>();  
      for(int i = 0; i<inorder.length; i++)
      {
           int v1 = inorder[i];
           map.put(v1, i);
       }   
        
        
       return preOrderTraversal(postorder, inorder, 0, postorder.length - 1);
    }
    
    public TreeNode preOrderTraversal(int[] postorder, int[] inorder, int left, int right) {
        
        if(left > right)
        {
            return null;
        } 
        
        int rval = postorder[postIndex--];
        TreeNode root= new TreeNode(rval);
        int idx = map.get(rval);
        
        root.right = preOrderTraversal(postorder, inorder, idx + 1, right); 
        root.left = preOrderTraversal(postorder, inorder, left, idx - 1);
        
        
        return root;
        
        
    }
}