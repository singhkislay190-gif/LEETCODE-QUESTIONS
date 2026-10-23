
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Create a dummy node to start the merged list
        ListNode dummy = new ListNode(0);

        // Tail points to the last node of the merged list
        ListNode tail = dummy;

        // Compare nodes while both lists have elements
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                // Attach the smaller node from list1
                tail.next = list1;
                list1 = list1.next;
            } else {
                // Attach the smaller node from list2
                tail.next = list2;
                list2 = list2.next;
            }

            // Move tail to the newly attached node
            tail = tail.next;
        }

        // Attach any remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the actual head, skipping the dummy node
        return dummy.next;
    }
}
