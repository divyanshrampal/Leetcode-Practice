/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    static int idx = 0;
    public void preorder(StringBuilder sb, TreeNode root){
         if(root == null){
            sb.append("null "); 
            return;
        }
        sb.append(root.val + " ");
        preorder(sb,root.left);
        preorder(sb,root.right);
        
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(sb,root);
        return sb.toString();
    }
    
    private TreeNode deserializeHelper(String[] input){
        if(idx == input.length){
            return null;
        }
        
        if(input[idx].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(input[idx]));
        idx++;
        node.left = deserializeHelper(input);
        idx++;
        node.right = deserializeHelper(input);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(" ");
        this.idx = 0;
        return deserializeHelper(input);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));