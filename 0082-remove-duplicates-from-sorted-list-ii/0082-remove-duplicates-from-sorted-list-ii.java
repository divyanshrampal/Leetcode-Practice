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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        ListNode dummyNode = new ListNode(-1);
        ListNode ptr = dummyNode;
        ListNode temp = head;
        while(temp != null){
            if(map.containsKey(temp.val)){
                map.put(temp.val, map.get(temp.val) + 1);
            }else{
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            if(map.get(temp.val) == 1){
                ListNode node = new ListNode(temp.val);
                ptr.next = node;
                ptr = ptr.next;
            }
            temp = temp.next;
        }
        
        return dummyNode.next;
    }
}