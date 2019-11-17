/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0),othersHead = new ListNode(0);
        ListNode prev = null;
        ListNode lessTail = lessHead,othersTail = othersHead;
        while(head != null ){
            if(head.val < x){
              lessTail.next = head;  
              lessTail = head;
            }
            else{
                othersTail.next = head;
                othersTail = head;
            }
           prev = head;
           head = head.next;
           prev.next = null;
        }
        lessTail.next = othersHead.next;
        return lessHead.next;
    }
}