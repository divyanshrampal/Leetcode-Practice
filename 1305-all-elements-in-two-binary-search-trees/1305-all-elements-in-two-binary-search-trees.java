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
    
    public void bstToSortedList(TreeNode root, List<Integer> li){
        if(root == null){
            return;
        }
        
        bstToSortedList(root.left, li);
        li.add(root.val);
        bstToSortedList(root.right, li);
    }
    
    public List<Integer> mergeTwoSortedArray(List<Integer> l1,List<Integer> l2){
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i) < l2.get(j)){
                ans.add(l1.get(i));
                i++;
            }
            else if(l1.get(i) > l2.get(j)){
                ans.add(l2.get(j));
                j++;
            }
            else{
                ans.add(l1.get(i));
                ans.add(l2.get(j));
                i++;
                j++;
            }  
        }
        
        if(i == l1.size()){
            while(j<l2.size()){
                ans.add(l2.get(j));
                j++;
            }
        }
        
        if(j == l2.size()){
            while(i<l1.size()){
                ans.add(l1.get(i));
                i++;
            }
        }
        
        return ans;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> bst1 = new ArrayList<>();
        List<Integer> bst2 = new ArrayList<>();
        
        bstToSortedList(root1, bst1);
        bstToSortedList(root2, bst2);
        
        return mergeTwoSortedArray(bst1, bst2);
    }  
}