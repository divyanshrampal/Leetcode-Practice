/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->{
            return a.val - b.val; // this - other for default behaviour
            // return b.val - a.val // other - this for max priority queue
        });
        for(ListNode head : lists){
            if(head != null)
              pq.add(head);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(pq.size() > 0){
            ListNode node = pq.remove();
            
            prev.next = node;
            prev = prev.next;
            node = node.next;
            
            if(node != null){
                pq.add(node);
            }
            
        }
        
        return dummy.next;
        
    }
}