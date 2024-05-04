/*
 * 203. Remove Linked List Elements
Solved
Easy
Topics
Companies
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

 */



 public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle cases where the first node needs to be removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements solution = new RemoveLinkedListElements();

        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        int val1 = 6;
        ListNode result1 = solution.removeElements(head1, val1);
        printLinkedList(result1); // Output: 1 -> 2 -> 3 -> 4 -> 5

        // Example 2
        ListNode head2 = null;
        int val2 = 1;
        ListNode result2 = solution.removeElements(head2, val2);
        printLinkedList(result2); // Output: null

        // Example 3
        ListNode head3 = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))));
        int val3 = 7;
        ListNode result3 = solution.removeElements(head3, val3);
        printLinkedList(result3); // Output: null
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.setLength(sb.length() - 4); // Remove the last " -> "
        System.out.println(sb.toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


//===================================Another Approach=======================================

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode removeElements(ListNode head, int val) {
//         if(head == null)return null;
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode curr = dummy;

//         while(curr.next != null){
//            if(curr.next.val == val){
//                 curr.next = curr.next.next;
//             }
//            else{
//             curr = curr.next;
//            }
//         }
//         return dummy.next;
//     }
// }