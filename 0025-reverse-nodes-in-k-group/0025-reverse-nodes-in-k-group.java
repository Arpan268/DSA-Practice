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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode merge = head;
        ListNode prev = null;
        ListNode newhead = null;
        int count = k;

        while (count > 1 && fast != null) {
            fast = fast.next;
            count--;
        }
        newhead = fast;
        if (fast == null) {
            return head;
        } else {
            fast = fast.next;
        }

        if (fast == null) {
            while (slow != null) {
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            return newhead;
        }

        while (slow != null) {
            if (slow == fast) {
                ListNode tempfast = fast;
                count = k;
                while (count > 1 && fast != null) {
                    fast = fast.next;
                    count--;
                }
                if (fast == null && count > 0) {
                    merge.next = tempfast;
                    break;
                }
                merge.next = fast;
                merge = tempfast;
                slow = tempfast;
                prev = null;
                if (fast != null) {
                    fast = fast.next;
                }
            }
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        return newhead;
    }
}