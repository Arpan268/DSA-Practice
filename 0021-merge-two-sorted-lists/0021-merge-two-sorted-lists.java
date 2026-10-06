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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        }

        ListNode current1 = null;
        ListNode current2 = null;
        ListNode mergedhead = null;

        if (list1.val <= list2.val) {
            current1 = list1;
            current2 = list2;
            mergedhead = list1;
        } else {
            current1 = list2;
            current2 = list1;
            mergedhead = list2;
        }

        while (current1 != null && current2 != null) {
            if(current1.next == null) {
                current1.next = current2;
                break;
            }
            else if (current1.val <= current2.val && current2.val <= current1.next.val) {
                ListNode temp1 = current2.next;
                ListNode temp2 = current1.next;
                current1.next = current2;
                current2.next = temp2;
                current2 = temp1;
                current1 = current1.next;
            } else {
                current1 = current1.next;
            }
        }

        return mergedhead;
    }
}