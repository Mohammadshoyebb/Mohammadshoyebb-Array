/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in the list is in the range [1, 105].
 * - 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList_LeetCodeDay58 {
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
     * Checks if the given singly linked list is a palindrome.
     *
     * @param head The head of the linked list.
     * @return True if the linked list is a palindrome, false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = prev;

        // Check if the first half and the reversed second half are equal
        ListNode p1 = head;
        ListNode p2 = slow.next;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList_LeetCodeDay58 solution = new PalindromeLinkedList_LeetCodeDay58();

        // Test cases
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println("Is linked list 1 a palindrome? " + solution.isPalindrome(head1)); // Output: true

        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Is linked list 2 a palindrome? " + solution.isPalindrome(head2)); // Output: false
    }
}

//----------------------------------------------------------------------------------
/*
 class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode ptr = head ;

        while(ptr!=null){
            st.push(ptr.val);
            ptr = ptr.next;
        }

        ListNode ptr2 = head ;

        while(ptr2!=null){
            int val1 = ptr2.val;
            int val2 = st.pop();

            if(val1 != val2 ){
                return false ;
            }
            ptr2 = ptr2.next;
        }

        return true ;
    }
}
 */