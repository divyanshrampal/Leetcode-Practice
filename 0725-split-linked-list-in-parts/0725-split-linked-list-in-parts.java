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
    
    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        return len;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        
        int len = getLength(head);
        int sizeEachPart = len/k;
        int extraNodes = len % k;
        ListNode curr = head;
        
        for(int i = 0; i < ans.length; i++){
            int size =  sizeEachPart;
            ListNode temp = new ListNode(-1);
            ListNode mark = temp;
            while(curr != null && size > 0){
               
                ListNode newNode = new ListNode(curr.val);
                temp.next = newNode;
                temp = temp.next;
                size--;
                curr = curr.next;
            }
            
            if(extraNodes > 0){
                ListNode newNode = new ListNode(curr.val);
                temp.next = newNode;
                extraNodes--;
                curr = curr.next;
            }
            ans[i] = mark.next;
        }
        return ans;
        
    }
}