/**
 * 21. Merge Two Sorted Lists
 * Easy
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100
 * - Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists_LeetCodeDay59 {
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
     * Merges two sorted linked lists into one sorted list.
     * 
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy head to simplify the code
        ListNode dummyHead = new ListNode(-1);
        // Initialize a current pointer to keep track of the current node in the merged list
        ListNode current = dummyHead;

        // Traverse both lists until one of them becomes null
        while (list1 != null && list2 != null) {
            // Compare the values of the nodes from both lists
            if (list1.val <= list2.val) {
                // If the value of the current node in list1 is less than or equal to list2,
                // append the current node from list1 to the merged list and move list1 to its next node
                current.next = list1;
                list1 = list1.next;
            } else {
                // If the value of the current node in list2 is less than list1,
                // append the current node from list2 to the merged list and move list2 to its next node
                current.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer to the next node in the merged list
            current = current.next;
        }

        // Append the remaining nodes from either list1 or list2 to the merged list
        current.next = list1 != null ? list1 : list2;

        // Return the head of the merged list (excluding the dummy head)
        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists_LeetCodeDay59 solution = new MergeTwoSortedLists_LeetCodeDay59();

        // Test cases
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        printList(mergedList); // Output: [1,1,2,3,4,4]

        ListNode emptyList1 = null;
        ListNode emptyList2 = null;
        ListNode mergedEmptyLists = solution.mergeTwoLists(emptyList1, emptyList2);
        printList(mergedEmptyLists); // Output: []

        ListNode emptyList3 = null;
        ListNode list3 = new ListNode(0);
        ListNode mergedEmptyList = solution.mergeTwoLists(emptyList3, list3);
        printList(mergedEmptyList); // Output: [0]
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

/**
 * Explanation:
 * 
 * To merge two sorted linked lists, we initialize a dummy head to simplify the code. Then, we use two pointers to traverse
 * both lists simultaneously. At each step, we compare the values of the current nodes from both lists and append the smaller
 * one to the merged list. We continue this process until one of the lists becomes null. Finally, we append the remaining
 * nodes from the non-null list to the merged list. The time complexity of this algorithm is O(m + n), where m and n are the
 * lengths of the input lists, as we traverse each list only once.
 */

