
/**
 * Code
 * 2816. Double a Number Represented as a Linked List
 * Solved
 * Medium
 * 
 * You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
 * Return the head of the linked list after doubling it.
 * 
 * Example 1:
 * Input: head = [1,8,9]
 * Output: [3,7,8]
 * Explanation: The figure above corresponds to the given linked list which represents the number 189.
 * Hence, the returned linked list represents the number 189 * 2 = 378.
 * 
 * Example 2:
 * Input: head = [9,9,9]
 * Output: [1,9,9,8]
 * Explanation: The figure above corresponds to the given linked list which represents the number 999.
 * Hence, the returned linked list represents the number 999 * 2 = 1998.
 * 
 * Constraints:
 * The number of nodes in the list is in the range [1, 104]
 * 0 <= Node.val <= 9
 * The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
 */


 // Definition for singly-linked list.


 public class DoubleNumberRepresentedAsLinkedList_65 {
    public ListNode doubleNumber(ListNode head) {
        // Reverse the linked list
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        
        // Double the number represented by the linked list
        int carry = 0;
        current = head;
        while (current != null) {
            int sum = current.val * 2 + carry;
            current.val = sum % 10;
            carry = sum / 10;
            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                break;
            }
            current = current.next;
        }
        
        // Reverse the linked list back to its original order
        prev = null;
        current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        
        return head;
    }
    
    public static void main(String[] args) {
        // Test cases
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        printList(head1);
        ListNode result1 = new DoubleNumberRepresentedAsLinkedList_65().doubleNumber(head1);
        printList(result1); // Expected: [3,7,8]

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        printList(head2);
        ListNode result2 = new DoubleNumberRepresentedAsLinkedList_65().doubleNumber(head2);
        printList(result2); // Expected: [1,9,9,8]
    }
    
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
