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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode smallest = null;

        for(ListNode node: lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        while(!pq.isEmpty()) {
            smallest = pq.poll();
            current.next = smallest;
            if(smallest.next != null) {
                pq.add(smallest.next);
            }
            current = current.next;
        }

        return dummy.next;
    }
}