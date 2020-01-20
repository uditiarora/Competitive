/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode curr,prev;
        while(head != null && head.val == val) head = head.next;
        if(head == null) return head;
        for(curr = head.next,prev = head; curr != null; curr = curr.next){
            if(curr.val != val){
                prev.next = curr;
                prev = prev.next;
            }
        }
        if(curr == null && prev.next != null) prev.next = null;
        return head;
    }
}