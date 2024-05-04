/*
 * 
 * 142. Linked List Cycle II
Solved
Medium
Topics
Companies
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */



public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Check if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle detected, move slow pointer to head and start both pointers again
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Return the node where cycle begins
            }
        }
        return null; // No cycle detected
    }

    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();

        // Example 1
        ListNode head1 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Create a cycle
        ListNode result1 = solution.detectCycle(head1);
        if (result1 != null) {
            System.out.println("Cycle detected, tail connects to node at index " + getIndex(head1, result1));
        } else {
            System.out.println("No cycle detected");
        }

        // Example 2
        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        head2.next = node4;
        node4.next = head2; // Create a cycle
        ListNode result2 = solution.detectCycle(head2);
        if (result2 != null) {
            System.out.println("Cycle detected, tail connects to node at index " + getIndex(head2, result2));
        } else {
            System.out.println("No cycle detected");
        }

        // Example 3
        ListNode head3 = new ListNode(1);
        ListNode result3 = solution.detectCycle(head3);
        if (result3 != null) {
            System.out.println("Cycle detected, tail connects to node at index " + getIndex(head3, result3));
        } else {
            System.out.println("No cycle detected");
        }
    }

    // Helper method to get the index of a node in a linked list
    public static int getIndex(ListNode head, ListNode node) {
        int index = 0;
        while (head != node) {
            head = head.next;
            index++;
        }
        return index;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
