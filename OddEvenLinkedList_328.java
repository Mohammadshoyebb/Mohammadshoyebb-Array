/*
 * 
Code
Testcase
Test Result
Test Result
328. Odd Even Linked List
Solved
Medium
Topics
Companies
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106

 */



//  public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return oddHead;
    }

    public static void main(String[] args) {
        // Test cases
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        OddEvenLinkedList_328 solution1 = new OddEvenLinkedList_328();
        ListNode result1 = solution1.oddEvenList(head1);
        printLinkedList(result1); // Output: [1, 3, 5, 2, 4]

        // Example 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        OddEvenLinkedList_328 solution2 = new OddEvenLinkedList_328();
        ListNode result2 = solution2.oddEvenList(head2);
        printLinkedList(result2); // Output: [2, 3, 6, 7, 1, 5, 4]
    }

    // Helper method to print linked list values
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
