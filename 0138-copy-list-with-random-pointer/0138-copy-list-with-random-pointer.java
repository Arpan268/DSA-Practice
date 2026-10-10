/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node clone = dummy;
        Node original = head;

        while(original != null) {
            clone.next = new Node(original.val);
            map.put(original, clone.next);
            clone = clone.next;
            original = original.next;
        }

        clone = dummy.next;
        original = head;
        while(clone != null) {
            clone.random = map.get(original.random);
            clone = clone.next;
            original = original.next;
        }

        return dummy.next;
    }
}