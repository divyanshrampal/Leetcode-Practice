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
    
    class Pair {
        TreeNode node = null;
        int vLevel = 0; // horizontal Level

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
    }
    
    public void mergeWithMap(HashMap<Integer, List<Integer>> tempMap, HashMap<Integer, List<Integer>> mainMap){
        for(int vLevel : tempMap.keySet()){
            List<Integer> tempList = tempMap.get(vLevel);
            List<Integer> mainList = mainMap.get(vLevel);
            if(mainList == null){
                mainList = new ArrayList<>();
                mainMap.put(vLevel, mainList);
            }
            Collections.sort(tempList);
            for(int val : tempList){
                mainList.add(val);
            }
            
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // BFS QUEUE
        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(root, 0));
        
        // MAIN MAP
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int minHL = 0;
        int maxHL = 0;

        while (q.size() != 0) {
            int size = q.size();
            
            // TEMP MAP
            HashMap<Integer, List<Integer>> tempMap = new HashMap<>();
            
            while (size-- > 0) {
                Pair rp = q.remove();

                if (rp.node.left != null){
                    q.add(new Pair(rp.node.left, rp.vLevel - 1));
                }   

                if (rp.node.right != null){
                    q.add(new Pair(rp.node.right, rp.vLevel + 1));
                }
                
                List<Integer> list = tempMap.get(rp.vLevel);
                if(list == null){
                    list = new ArrayList<>();
                    tempMap.put(rp.vLevel, list);
                }
                list.add(rp.node.val);

                minHL = Math.min(minHL, rp.vLevel);
                maxHL = Math.max(maxHL, rp.vLevel);
                
            }
            mergeWithMap(tempMap, map);
        }

        
        List<List<Integer>> ans = new ArrayList<>();
        while (minHL <= maxHL) {
            ans.add(map.get(minHL));
            minHL++;
        }

        return ans;
    }
}








