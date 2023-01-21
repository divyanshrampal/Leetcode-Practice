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
    
    public int findMax(List<Integer> l){
        int max = l.get(0);
        for(int i = 1; i<l.size(); i++){
            if(l.get(i) > max){
                max = l.get(i);
            }
        }
        
        return max;
    }
    
    public List<Integer> largestValues(TreeNode root) {
     Queue<TreeNode> que = new LinkedList<>();
     que.add(root);
     List<Integer> ans = new ArrayList<>();   
     
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
             ans.add(findMax(list));
     }
     
     return ans;
    }
}