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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                fast = fast.next;
            } else {
                if (fast.next.next != null) {
                    slow = slow.next;
                }
                fast = fast.next.next;
            }
        }

        ListNode current = slow.next;
        ListNode prev = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        slow.next = null;

        ListNode reorder = head;
        while(prev != null) {
            ListNode temp1 = prev.next;
            ListNode temp2 = reorder.next;
            reorder.next = prev;
            prev.next = temp2;
            prev = temp1;
            reorder = reorder.next.next;
        }
    }
}