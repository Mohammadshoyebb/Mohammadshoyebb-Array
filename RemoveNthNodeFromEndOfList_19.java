/*
 * 
Code
Testcase
Test Result
Test Result
19. Remove Nth Node From End of List
Solved
Medium
Topics
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
 */




//  public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move the fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both slow and fast pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test cases
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int n1 = 2;
        RemoveNthNodeFromEndOfList_19 solution = new RemoveNthNodeFromEndOfList_19();
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        printLinkedList(result1); // Output: 1 -> 2 -> 3 -> 5

        // Example 2
        ListNode head2 = new ListNode(1);
        int n2 = 1;
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        printLinkedList(result2); // Output: []

        // Example 3
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        int n3 = 1;
        ListNode result3 = solution.removeNthFromEnd(head3, n3);
        printLinkedList(result3); // Output: 1
    }

    // Helper method to print linked list
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

