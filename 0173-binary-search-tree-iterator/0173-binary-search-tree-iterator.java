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
    
    Stack<TreeNode> st;
        
    public BSTIterator(TreeNode root) {
        
        this.st = new Stack<>();
        addAllLeft(root);
    }
    
    public int next() {
        TreeNode topNode = this.st.pop();
        addAllLeft(topNode.right);
        return topNode.val;
    }
    
    public boolean hasNext() {
        return this.st.size() != 0;
    }
    
    private void addAllLeft(TreeNode root){
       
        while(root != null){
            this.st.push(root);
            root = root.left;
        }
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */