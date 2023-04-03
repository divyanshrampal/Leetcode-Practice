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
    
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        
        return head;
        
    }
    
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = middleNode(head);
        ListNode half = mid.next;
        mid.next = null;
        half = reverseList(half);
        while(head != null && half != null){
            if(head.val != half.val){
                return false;
            }
            head = head.next;
            half = half.next;
        }
        
        return true;
        
    }
}