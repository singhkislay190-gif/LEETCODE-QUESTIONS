
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to simplify creating the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Continue while either list has nodes or carry remains
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            // Add digit from first list, if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add digit from second list, if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Get the digit to store in the result
            int digit = sum % 10;

            // Calculate carry for the next position
            carry = sum / 10;

            // Add the digit to the result list
            current.next = new ListNode(digit);
            current = current.next;
        }

        // Return the first actual node, skipping the dummy node
        return dummy.next;
    }
}
