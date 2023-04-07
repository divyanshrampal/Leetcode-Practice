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
class BSTIterator {
     
    
    List<Integer> inorder;
    int i;
        
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        i = 0;
        getInorder(root);
    }
    
    public int next() {
        int ans = inorder.get(i);
        i += 1;
        return ans;
    }
    
    public boolean hasNext() {
        return i < inorder.size();
    }
    
    private void getInorder(TreeNode root){
        if(root == null){
            return;
        }
        getInorder(root.left);
        inorder.add(root.val);
        getInorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */