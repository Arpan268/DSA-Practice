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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0, sum = 0;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
            }
            else if(l1 == null) {
                sum = l2.val + carry;
            }
            else if(l2 == null) {
                sum = l1.val + carry;
            }

            if(sum < 10) {
                current.next = new ListNode(sum);
                current = current.next;
                carry = 0;
            }
            else {
                current.next = new ListNode (sum - 10);
                current = current.next;
                carry = 1;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry == 1) {
            current.next = new ListNode(1);
        }

        return dummy.next;
    }
}