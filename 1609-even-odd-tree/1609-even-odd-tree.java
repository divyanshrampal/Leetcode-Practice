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
    private boolean isEvenIndexed(List<Integer> list){
        
        if(list.size() == 1){
            return (list.get(0) % 2 != 0);
        }
        
        for(int i = 1; i < list.size(); i++){
            int curr = list.get(i);
            int prev = list.get(i - 1);
            
            if(prev % 2 == 0 || curr % 2 == 0){
                return false;
            }
            
            else{
                if(prev >= curr){
                return false;
               }
            }
            

        }
        
        return true;
    }
    
    private boolean isOddIndexed(List<Integer> list){
        
        if(list.size() == 1){
            return (list.get(0) % 2 == 0);
        }
        
        for(int i = 1; i < list.size(); i++){
            int curr = list.get(i);
            int prev = list.get(i - 1);
            
            if(prev % 2 != 0 || curr % 2 != 0){
                return false;
            }
            
            else {
                if(prev <= curr){
                    return false;
                }
            }    
        }
        
        return true;
    }
    
    public boolean isEvenOddTree(TreeNode root) {
     
     Queue<TreeNode> que = new LinkedList<>();
     que.add(root);
     int level = -1;   
     
     while(que.size() != 0)
     {
          level++;
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
          
          if(list.size() > 0){
              //System.out.println(level + "->" + list);
              if(level % 2 == 0){
                  if(isEvenIndexed(list) == false){
                      return false;
                  }
              }
              else{
                  if(isOddIndexed(list) == false){
                      return false;
                  }
              }
          }
     }
     
     return true;
    }
}