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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        while(que.size() > 0){
            int size = que.size();
            int temp = size;
            double sum = 0;
            while(size > 0){
                TreeNode rem = que.remove();
                sum += rem.val;
                if(rem.left != null){
                    que.add(rem.left);
                }
                if(rem.right != null){
                    que.add(rem.right);
                }
                size--;
            }
            ans.add(sum/temp);
        }

        return ans;
    }
}