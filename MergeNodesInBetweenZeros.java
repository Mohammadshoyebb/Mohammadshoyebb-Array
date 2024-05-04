/**
 * 2181. Merge Nodes in Between Zeros
 * 
 * You are given the head of a linked list, which contains a series of integers separated by 0's.
 * The beginning and end of the linked list will have Node.val == 0.
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value
 * is the sum of all the merged nodes. The modified list should not contain any 0's.
 * Return the head of the modified linked list.
 * 
 * Example 1:
 * Input: head = [0,3,1,0,4,5,2,0]
 * Output: [4,11]
 * Explanation: 
 * The above figure represents the given linked list. The modified list contains
 * - The sum of the nodes marked in green: 3 + 1 = 4.
 * - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
 * 
 * Example 2:
 * Input: head = [0,1,0,3,0,2,2,0]
 * Output: [1,3,4]
 * Explanation: 
 * The above figure represents the given linked list. The modified list contains
 * - The sum of the nodes marked in green: 1 = 1.
 * - The sum of the nodes marked in red: 3 = 3.
 * - The sum of the nodes marked in yellow: 2 + 2 = 4.
 * 
 * Constraints:
 * - The number of nodes in the list is in the range [3, 2 * 105].
 * - 0 <= Node.val <= 1000
 * - There are no two consecutive nodes with Node.val == 0.
 * - The beginning and end of the linked list have Node.val == 0.
 */

 public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == 0 && curr.next.val == 0) {
                ListNode merged = merge(curr);
                prev.next = merged;
                curr = merged;
            } else {
                prev.next = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    private ListNode merge(ListNode start) {
        ListNode merged = new ListNode(0);
        ListNode curr = start.next;
        int sum = 0;

        while (curr != null && curr.val != 0) {
            sum += curr.val;
            curr = curr.next;
        }

        merged.val = sum;
        merged.next = curr;

        return merged;
    }

    public static void main(String[] args) {
        MergeNodesInBetweenZeros solution = new MergeNodesInBetweenZeros();

        // Example 1
        ListNode head1 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4,
                new ListNode(5, new ListNode(2, new ListNode(0))))))));
        ListNode result1 = solution.mergeNodes(head1);
        printList(result1); // Output: 4 -> 11

        // Example 2
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0,
                new ListNode(2, new ListNode(2, new ListNode(0))))))));
        ListNode result2 = solution.mergeNodes(head2);
        printList(result2); // Output: 1 -> 3 -> 4
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


//=========================simple approach================================

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
//     public ListNode mergeNodes(ListNode head) {
//         if(head == null || head.next == null || head.next.next == null) return null;
//         ListNode dummy = new ListNode(-1);
//         ListNode answer = dummy;
//         ListNode curr = head.next;

//         int sum = 0;
//         while(curr != null ){
//             if(curr.val != 0){
//                 sum += curr.val;
//             }
//             else
//             {
//                 ListNode temp = new ListNode(sum);
//                 dummy.next = temp;
//                 dummy = dummy.next;
//                 sum = 0;
//             }
//             curr = curr.next;

//         }
//         return answer.next;       
        
//     }
// }

//=================================ANOTHER METHOD (4 ms)===================================
/*
class Solution {
    public ListNode mergeNodes(ListNode head) {
		ListNode ans = head;
		ListNode curr = ans;
		head = head.next;
		while (head != null) {
			while (head.val != 0) {
				curr.val += head.val;
				head = head.next;
			}
			curr.next = head.next;
			curr = curr.next;
			head = curr == null ? null : curr.next;
		}
		return ans;
    }
}
*/