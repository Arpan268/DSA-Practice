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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = null;
        int nodes = 0;

        while(fast != null) {
            nodes++;
            if(nodes == n + 1) {
                slow = head;
            }
            if(fast.next == null && nodes == n) {
                head = head.next;
                break;
            }
            if(fast.next == null && slow != null) {
                slow.next = slow.next.next;
                fast = fast.next;
                break;
            }
            if(slow != null) {
                slow = slow.next;
            }
            fast = fast.next;
        }

        return head;
    }
}