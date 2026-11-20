
class Solution {
    public ListNode partition(ListNode head, int x) {

        // Create two dummy nodes
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        // Pointers for both lists
        ListNode smallHead = small;
        ListNode largeHead = large;

        // Traverse the original linked list
        while (head != null) {

            if (head.val < x) {

                // Add node to smaller list
                small.next = head;
                small = small.next;

            } else {

                // Add node to greater or equal list
                large.next = head;
                large = large.next;
            }

            // Move to next node
            head = head.next;
        }

        // End the greater or equal list
        large.next = null;

        // Connect both lists
        small.next = largeHead.next;

        // Return the final linked list
        return smallHead.next;
    }
}
