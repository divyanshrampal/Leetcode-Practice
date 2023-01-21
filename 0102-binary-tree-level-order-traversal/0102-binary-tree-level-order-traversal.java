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
    public List<List<Integer>> levelOrder(TreeNode root) {
     Queue<TreeNode> que = new LinkedList<>();
     que.add(root);
     List<List<Integer>> ans = new ArrayList<>();   
     
     while(que.size() != 0)
     {
          int size = que.size();
          List<Integer> list = new ArrayList<>();
                   
          while(size-- > 0)
          {
              TreeNode rem = que.remove();
              if(rem == null)
              {
                  continue;
              }
              list.add(rem.val);
              que.add(rem.left);
              que.add(rem.right);
          }
          if(list.size() > 0)
            ans.add(list);
     }
     
     return ans;
    }
}