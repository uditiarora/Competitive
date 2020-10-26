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
    private ListNode reverse(ListNode head){
        if(head == null)
            return null;
        
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;
        
        ListNode dummyNode = new ListNode(-1);
        ListNode ptr = dummyNode;
        
        ListNode node = head;
        while(node != null){
            ListNode start = node;
            
            for(int i = 1; i< k && node != null; i++){
                node = node.next;
            }

            if(node != null){
                ListNode next = node.next;
                node.next = null; //end this here
                ptr.next = reverse(start); //reverse shall return head
                ptr = start; //After reversing first becomes last node
                start.next = null;
                node = next;
            }
            else{ //We didn't see k nodes during the traversal
                ptr.next = start;
                return dummyNode.next;
            }
        }
        
        return dummyNode.next;
    }
}