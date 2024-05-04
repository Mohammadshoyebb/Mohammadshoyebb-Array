/**
 * 2095. Delete the Middle Node of a Linked List
 * 
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 * 
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
 * where ⌊x⌋ denotes the largest integer less than or equal to x.
 * 
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 * 
 * Example 1:
 * Input: head = [1,3,4,7,1,2,6]
 * Output: [1,3,4,1,2,6]
 * Explanation:
 * The above figure represents the given linked list. The indices of the nodes are written below.
 * Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
 * We return the new list after removing this node. 
 * 
 * Example 2:
 * Input: head = [1,2,3,4]
 * Output: [1,2,4]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 4, node 2 with value 3 is the middle node, which is marked in red.
 * 
 * Example 3:
 * Input: head = [2,1]
 * Output: [2]
 * Explanation:
 * The above figure represents the given linked list.
 * For n = 2, node 1 with value 1 is the middle node, which is marked in red.
 * Node 0 with value 2 is the only node remaining after removing node 1.
 * 
 * Constraints:
 * - The number of nodes in the list is in the range [1, 10^5].
 * - 1 <= Node.val <= 10^5
 */

 public class DeleteMiddleNodeOfLinkedList {
    public ListNode deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No middle node to delete
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node (slow)
        prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        DeleteMiddleNodeOfLinkedList solution = new DeleteMiddleNodeOfLinkedList();

        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7,
                new ListNode(1, new ListNode(2, new ListNode(6)))))));
        ListNode result1 = solution.deleteMiddleNode(head1);
        printList(result1); // Output: 1 -> 3 -> 4 -> 1 -> 2 -> 6

        // Example 2
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result2 = solution.deleteMiddleNode(head2);
        printList(result2); // Output: 1 -> 2 -> 4

        // Example 3
        ListNode head3 = new ListNode(2, new ListNode(1));
        ListNode result3 = solution.deleteMiddleNode(head3);
        printList(result3); // Output: 2
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
