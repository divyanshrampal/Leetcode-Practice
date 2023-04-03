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
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        ListNode start = null;
        ListNode end = null;
        int i = 1;
        while(temp != null){
            if(i == k){
                start = temp;
            }
            temp = temp.next;
            i += 1;
            length++;
        }
        temp = head;
        i = 1;
        while(temp != null){
            if(i == (length-k+1)){
                end = temp;
            }
            temp = temp.next;
            i += 1;
        }
        
        //swap
        int t = start.val;
        start.val = end.val;
        end.val = t;
        
        return head;
        
    }
}