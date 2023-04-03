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
    
    public ListNode merge(ListNode first, ListNode second){
        // if only one element is present in 1st list
        if(first.next == null){
            first.next = second;
            return first;
        }
        
        ListNode curr1 = first;
        ListNode next1 = first.next;
        ListNode curr2 = second;
        
        while(next1 != null && curr2 != null){
             if(curr2.val >= curr1.val && curr2.val <= next1.val){
                 
                 curr1.next = curr2;
                 ListNode next2 = curr2.next;
                 curr2.next = next1;
                 curr1 = curr2 ;
                 curr2 = next2;
                  
             }
            else{
                curr1 = next1;
                next1 = next1.next;
                
                if(next1 == null){
                    curr1.next = curr2;
                    return first;
                }
            }
        }
        
        return first;
        
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        
        if(list2 == null){
            return list1;
        }
        
        if(list1.val <= list2.val){
            return merge(list1, list2);
        }
        
        else{
            return merge(list2, list1);
        }
        
    }
}