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
         Queue<TreeNode> que = new LinkedList<>();
         int flag = -1;
         que.add(root);
         List<List<Integer>> ans = new ArrayList<>();   

         while(que.size() != 0)
         {
              int size = que.size();
              List<Integer> list = new ArrayList<>();
              flag++;
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
              if(flag % 2 == 0){
                  if(list.size() > 0)
                   ans.add(list);
              }
              else{
                  if(list.size() > 0){
                      List<Integer> revlist = new ArrayList<>();
                      for(int i = list.size() - 1; i >= 0; i--){
                          revlist.add(list.get(i));
                      }
                      ans.add(revlist);
                  }
              }
              
         }

         return ans;
        
        
    }
}