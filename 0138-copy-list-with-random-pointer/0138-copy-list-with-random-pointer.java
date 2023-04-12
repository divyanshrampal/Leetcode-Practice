/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null){
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        Node copyTemp = copyHead;
        Node temp = head.next;
        
        map.put(head, copyHead);
        
        while(temp != null)
        {
            Node newNode = new Node(temp.val);
            copyTemp.next = newNode;
            map.put(temp, newNode);
            copyTemp = copyTemp.next;
            temp = temp.next;
        }    
        
        copyTemp = null;
        
        // for(Node t : map.keySet()){
        //     System.out.println(t.val + " " + map.get(t).val );
        // }
        
        temp = head;
        while(temp != null){
           Node copyNode = map.get(temp); 
           Node randomNode = temp.random;
           Node copyRandomNode = map.get(randomNode);
           copyNode.random =  copyRandomNode;
           
            temp = temp.next;
        }
        
        return copyHead;
        
    }
}