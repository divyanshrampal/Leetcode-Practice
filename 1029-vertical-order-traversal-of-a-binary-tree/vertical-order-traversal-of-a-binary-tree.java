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

    public void minMaxHorizontalDistance(TreeNode node, int horizontalDistance, int[] minMax){
        if(node == null)
            return;
        
        if(horizontalDistance < minMax[0]){
            minMax[0] = horizontalDistance;
        }
        else if(horizontalDistance > minMax[1]){
            minMax[1] = horizontalDistance;
        }

        minMaxHorizontalDistance(node.left, horizontalDistance - 1, minMax);
        minMaxHorizontalDistance(node.right, horizontalDistance + 1, minMax);

    }

    public void addVerticalNode(TreeNode node, int horizontalDistance, int verticalLine, int depth, List<int[]> list) {
        if (node == null)
            return;

        if (horizontalDistance == verticalLine) {
            list.add(new int[]{node.val, depth});
        }

        addVerticalNode(node.left, horizontalDistance - 1, verticalLine, depth + 1, list);
        addVerticalNode(node.right, horizontalDistance + 1, verticalLine, depth + 1, list);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();

        int[] minMax = new int[]{0, 0};
        minMaxHorizontalDistance(root, 0, minMax); // root is at 0th vertical line

        for(int i = minMax[0]; i <= minMax[1] ; i++){
            List<int[]> temp = new ArrayList<>();
            addVerticalNode(root, 0, i,0, temp);
            //Collections.sort(temp);
            Collections.sort(temp, (a, b) -> {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            List<Integer> sorted = new ArrayList<>();
            for (int[] pair : temp) {
                sorted.add(pair[0]);
            }
            result.add(sorted);
        }

        return result;
    }
}