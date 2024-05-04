/*
 * 23. Merge k Sorted Lists
Solved
Hard
Topics
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

 */



import java.util.*;
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the heads of all lists to the minHeap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // Continuously extract the smallest node from the minHeap and add it to the merged list
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;
            
            if (minNode.next != null) {
                minHeap.add(minNode.next); // Add the next node of the extracted node to the minHeap
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Example 1
        ListNode[] lists1 = new ListNode[] {
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };
        ListNode merged1 = solution.mergeKLists(lists1);
        printList(merged1); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
        
        // Example 2
        ListNode[] lists2 = new ListNode[0];
        ListNode merged2 = solution.mergeKLists(lists2);
        printList(merged2); // Output: null
        
        // Example 3
        ListNode[] lists3 = new ListNode[] {null};
        ListNode merged3 = solution.mergeKLists(lists3);
        printList(merged3); // Output: null
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



//=====================================ANother methods=====================================

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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length == 0)return null;
//         if(lists.length == 1) return lists[0];

//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
//         for(int i=0; i<lists.length; i++){
//             ListNode tempHead = lists[i];

//             while(tempHead != null){
//                 pq.add(tempHead);
//                 tempHead = tempHead.next;
//             }
//         }
//         ListNode dummy = new ListNode(-1);
//         ListNode ans = dummy;

//         while(pq.size()>0){
//             ListNode newNode = pq.remove();
//             dummy.next = newNode;
//             dummy = dummy.next;
//         }
//     dummy.next = null;

//     return ans.next;
//     }
// }




//==========================Another Approach==================================


// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode mergeTwoList(ListNode lista, ListNode listb){
//         ListNode cura = lista, curb = listb, head = new ListNode(-1);
//         ListNode prev = head;
//         while(cura!=null && curb!=null){
//             if(cura.val>curb.val){
//                 prev.next = curb;
//                 curb = curb.next;
//             }else{
//                 prev.next = cura;
//                 cura = cura.next;
//             }
//             prev = prev.next;
//         }
//         if(cura!=null)prev.next = cura;
//         else prev.next = curb;
//         return head.next;
//     }
//     public ListNode mergeKListRecursive(ListNode[] lists,int si, int ei){
//         if(si == ei)return lists[si];
//         int mid = si+(ei-si)/2;
//         return mergeTwoList(mergeKListRecursive(lists,si,mid),mergeKListRecursive(lists,mid+1,ei));
//     }
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists.length==0 )return null;
//         return mergeKListRecursive(lists,0,lists.length-1);
//     }
// }


//==================================Another Approach======================================

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//         }
//         return mergeLists(lists, 0, lists.length - 1);
//     }
    
//     private ListNode mergeLists(ListNode[] lists, int start, int end) {
//         if (start == end) {
//             return lists[start];
//         }
        
//         int mid = start + (end - start) / 2;
//         ListNode left = mergeLists(lists, start, mid);
//         ListNode right = mergeLists(lists, mid + 1, end);
        
//         return merge(left, right);
//     }
    
//     private ListNode merge(ListNode list1, ListNode list2) {
//         if (list1 == null) return list2;
//         if (list2 == null) return list1;
        
//         ListNode dummy = new ListNode(-1);
//         ListNode current = dummy;
        
//         while (list1 != null && list2 != null) {
//             if (list1.val < list2.val) {
//                 current.next = list1;
//                 list1 = list1.next;
//             } else {
//                 current.next = list2;
//                 list2 = list2.next;
//             }
//             current = current.next;
//         }
        
//         if (list1 != null) {
//             current.next = list1;
//         } else {
//             current.next = list2;
//         }
        
//         return dummy.next;
//     }
// }
