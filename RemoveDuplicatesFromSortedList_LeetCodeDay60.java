/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * Constraints:
 * - The number of nodes in the list is in the range [0, 300].
 * - -100 <= Node.val <= 100
 * - The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedList_LeetCodeDay60 {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Removes duplicates from a sorted linked list.
     * 
     * @param head The head of the sorted linked list.
     * @return The head of the linked list after removing duplicates.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // Check if the list is empty or contains only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize a pointer to traverse the list
        ListNode current = head;
        // Traverse the list until the end
        while (current.next != null) {
            // If the value of the current node is equal to the value of the next node,
            // skip the next node by updating the current node's next pointer
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        // Return the head of the updated list
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList_LeetCodeDay60 solution = new RemoveDuplicatesFromSortedList_LeetCodeDay60();

        // Test cases
        ListNode head1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result1 = solution.deleteDuplicates(head1);
        printList(result1); // Output: [1,2]

        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))); 
        ListNode result2 = solution.deleteDuplicates(head2);
        printList(result2); // Output: [1,2,3]
    }

    /**
     * Helper method to print the linked list.
     * 
     * @param head The head of the linked list.
     */
    private static void printList(ListNode head) {
        // Check if the linked list is empty
        if (head == null) {
            System.out.println("[]");
            return;
        }

        // Use a StringBuilder to construct the string representation of the linked list
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = head;
        // Traverse the linked list and append each node's value to the string
        while (current != null) {
            sb.append(current.val);
            // Append a comma if the current node is not the last node in the list
            if (current.next != null) {
                sb.append(",");
            }
            // Move to the next node in the list
            current = current.next;
        }
        sb.append("]");
        // Print the string representation of the linked list
        System.out.println(sb.toString());
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }

        ListNode dummy = new ListNode(head.val);
        ListNode  ans = dummy ;

        ListNode ptr = head.next ;

        while(ptr!=null){
            if(ptr.val!=dummy.val){
                // ListNode temp = new ListNode(ptr.val);
                dummy.next = ptr ;
                dummy = dummy.next;
            }
            ptr = ptr.next;
        }
        dummy.next = null; //extra line of new approach
        return ans ;
    }
}
 */
