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
    
    List<Integer> arr;
    int size;
    
    public Solution(ListNode head) {
        
        arr = new ArrayList<>();
        size = 0;
        
        while(head != null){
            size++;
            arr.add(head.val);
            head = head.next;
        }
        
    }
    
    public int getRandom() {
        
        int index = (int)(Math.random()*size)%size;
        return arr.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */