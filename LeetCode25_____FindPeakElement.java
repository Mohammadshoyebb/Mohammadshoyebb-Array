//  Find Peak Element
// Solved
// Medium
// Topics
// Companies
// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

// Constraints:

// 1 <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
// nums[i] != nums[i + 1] for all valid i.




public class LeetCode25_____FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is a peak
            if (nums[mid] > nums[mid + 1]) {
                // If mid is greater than its right neighbor, move left
                right = mid;
            } else {
                // If mid is not greater than its right neighbor, move right
                left = mid + 1;
            }
        }
        
        // At the end of the loop, left and right will be pointing to the same element, which is the peak
        return left;
    }

    public static void main(String[] args) {
        LeetCode25_____FindPeakElement solution = new LeetCode25_____FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.findPeakElement(nums1)); // Output: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(solution.findPeakElement(nums2)); // Output: 5
    }
}
