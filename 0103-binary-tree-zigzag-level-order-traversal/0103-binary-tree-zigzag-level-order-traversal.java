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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        boolean leftToRight = true;
        
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            
            Integer[] list = new Integer[size];
            for(int i = 0; i< size; i++){
                
                TreeNode front = q.remove();
                int index = leftToRight ? i : size - i - 1;
                list[index] = front.val;
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            leftToRight = !leftToRight;
            if(list.length > 0){
                List<Integer> arr = Arrays.asList(list);
                ans.add(arr);
            }
            
        }
        
        return ans;
    }
}