
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // If list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find length of linked list
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Reduce unnecessary rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Connect tail to head (make circular list)
        tail.next = head;

        // Find new tail
        int steps = len - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is next of new tail
        ListNode newHead = newTail.next;

        // Break the circular list
        newTail.next = null;

        return newHead;
    }
}
