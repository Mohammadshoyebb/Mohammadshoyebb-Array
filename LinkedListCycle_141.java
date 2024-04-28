/*
 * 141. Linked List Cycle
Solved
Easy
Topics
Companies
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */



// public class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int val) {
//         this.val = val;
//     }
// }

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
         
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // Cycle formed, pointing back to the second node

        LinkedListCycle_141 solution = new LinkedListCycle_141();
        System.out.println("Has cycle in linked list 1: " + solution.hasCycle(head1)); // Output: true

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // Cycle formed, pointing back to the first node

        System.out.println("Has cycle in linked list 2: " + solution.hasCycle(head2)); // Output: true

        // Example 3
        ListNode head3 = new ListNode(1);

        System.out.println("Has cycle in linked list 3: " + solution.hasCycle(head3)); // Output: false
    }
}

