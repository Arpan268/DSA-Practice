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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode node1 = head;
        ListNode node2 = null;

        while(node1 != null) {
            if(node1.next == null) {
                current.next = node1;
                break;
            }
            node2 = node1.next;    
            node1.next = node2.next;
            current.next = node2;
            node2.next = null;
            current.next.next = node1;
            node1 = node1.next;
            current = current.next.next;
        }

        return dummy.next;
    }
}