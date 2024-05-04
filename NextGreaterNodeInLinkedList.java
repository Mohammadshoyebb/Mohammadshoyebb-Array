/**
 * 1019. Next Greater Node In Linked List
Solved
Medium
Topics
Companies
Hint
You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

 

Example 1:


Input: head = [2,1,5]
Output: [5,5,0]
Example 2:


Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 104
1 <= Node.val <= 109
 */



import java.util.*;
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;

        // Convert linked list to list
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        // Iterate over the list in reverse to find the next greater node for each node
        for (int i = list.size() - 1; i >= 0; i--) {
            int val = list.get(i);

            // Pop elements from the stack until we find a greater element or the stack becomes empty
            while (!stack.isEmpty() && stack.peek() <= val) {
                stack.pop();
            }

            // If the stack is empty, there is no greater element
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek();
            }

            // Push the current value onto the stack
            stack.push(val);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList solution = new NextGreaterNodeInLinkedList();

        // Example 1
        ListNode head1 = new ListNode(2, new ListNode(1, new ListNode(5)));
        int[] result1 = solution.nextLargerNodes(head1);
        System.out.println(Arrays.toString(result1)); // Output: [5, 5, 0]

        // Example 2
        ListNode head2 = new ListNode(2, new ListNode(7, new ListNode(4, new ListNode(3, new ListNode(5)))));
        int[] result2 = solution.nextLargerNodes(head2);
        System.out.println(Arrays.toString(result2)); // Output: [7, 0, 5, 5, 0]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//===============================ANother Approach=====================================
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
//     public int LLsize(ListNode head){
//         int count = 0;
//         ListNode curr = head;
//         while(curr!=null){
//             count++;
//             curr = curr.next;
//         }
//         return count;
//     }
//     public ListNode LLReverse(ListNode head){
//         ListNode curr = head;
//         ListNode prev = null;
//         while(curr != null){
//             ListNode temp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = temp; 
//         }
//         return prev;
//     }
//     public int[] nextLargerNodes(ListNode head) {
//         int  count = LLsize(head);
//         ListNode newHead = LLReverse(head);
//         int arr[] = new int[count];

//         Stack<Integer> st = new Stack<>();
//         st.push(newHead.val);

//         ListNode curr = newHead.next;
//         int ptr = count-2;

//         while(ptr>=0){
//             int ele = curr.val;
//             curr = curr.next;

//             while(st.size()>0 && st.peek()<=ele){
//                 st.pop();
//             }
//             if(st.size()==0){
//                 arr[ptr] = 0;
//             }
//             else{
//                 arr[ptr] = st.peek();
//             }
//             st.push(ele);
//             ptr--;
//         }
//         return arr;
//     }
// }

//========================================================================================================================================================================================
/*
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
 /*
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode ptr = head;
        while(ptr!= null) {
            n++;
            ptr = ptr.next;
        }
        
        int[] ans = new int[n];
        int arrPtr = 0;
        ptr = head;
        while(ptr!= null) {
            ans[arrPtr] = ptr.val;
            arrPtr++;
            ptr = ptr.next;
        }
        //System.out.println(Arrays.toString(ans));
        int[] stack = new int[n];
        int stackPtr = -1;
        int temp;
        for(int i=n-1; i>=0; i--) {
            while(stackPtr >= 0 && stack[stackPtr] <= ans[i]) {
                stackPtr--;
            }
            //System.out.println(stackPtr + " " +  ans[i]);
            if(stackPtr < 0) {
                stack[++stackPtr] = ans[i];
                ans[i] = 0;
            } else {
                temp = ans[i];
                ans[i] = stack[stackPtr];
                stackPtr++;
                stack[stackPtr] = temp;
            }
            //System.out.println(Arrays.toString(stack) + stackPtr);
        }

        return ans;
    }
}
*/

//===========================================================================================



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

 /*
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int[] res = new int[nodes.size()];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nodes.size(); ++i) {
            ListNode curr = nodes.get(i);
            while (!deque.isEmpty() && nodes.get(deque.peekLast()).val < curr.val) {
                res[deque.removeLast()] = curr.val;
            }
            deque.addLast(i);
        }
        return res;
    }
}
*/
