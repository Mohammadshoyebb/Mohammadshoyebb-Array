/*
  Kth Largest Element in an Array
Solved
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 
  
  
 
 */



import java.util.PriorityQueue;

class KthLargestElement__leetcode35 {
    // Method to find the kth largest element in the array
    public int findKthLargest(int[] nums, int k) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add elements to the max heap
        for (int num : nums) {
            maxHeap.offer(num);

            // If the size of the heap exceeds k, remove the smallest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Return the top element of the max heap
        return maxHeap.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an instance of the solution class
        KthLargestElement_leetcode35 solution = new KthLargestElement_leetcode35();

        // Example cases
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Output for nums1 and k1: " + solution.findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Output for nums2 and k2: " + solution.findKthLargest(nums2, k2)); // Output: 4
    }
}
