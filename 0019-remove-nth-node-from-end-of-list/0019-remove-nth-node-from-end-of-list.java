
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: Calculate length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Find position from beginning
        int position = length - n;

        // Step 3: If first node needs to be deleted
        if (position == 0) {
            return head.next;
        }

        // Step 4: Traverse to previous node
        temp = head;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        // Step 5: Delete the node
        temp.next = temp.next.next;

        return head;
    }
}
