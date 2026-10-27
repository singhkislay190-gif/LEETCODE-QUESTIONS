
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {
            // Find the kth node of the current group
            ListNode kth = prevGroup;

            for (int i = 0; i < k; i++) {
                kth = kth.next;

                // Not enough nodes left
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode nextGroup = kth.next;

            // Reverse the current group
            ListNode prev = nextGroup;
            ListNode curr = prevGroup.next;

            while (curr != nextGroup) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect the reversed group
            ListNode temp = prevGroup.next;
            prevGroup.next = kth;
            prevGroup = temp;
        }
    }
}
