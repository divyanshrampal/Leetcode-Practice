//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class verticalPair {
        Node node = null;
        int hl = 0; // horizontal Level

        verticalPair(Node node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        LinkedList<verticalPair> que = new LinkedList<>();
        que.addLast(new verticalPair(root, 0));
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int minHL = 0;
        int maxHL = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                map.putIfAbsent(rp.hl, new ArrayList<>());
                // if (!map.containsKey(rp.hl))
                // map.put(rp.hl, new ArrayList<>());

                map.get(rp.hl).add(rp.node.data);

                minHL = Math.min(minHL, rp.hl);
                maxHL = Math.max(maxHL, rp.hl);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (minHL <= maxHL) {
            for(int val : map.get(minHL)){
                ans.add(val);
            }
            minHL++;
        }

        return ans;
        
    }
}