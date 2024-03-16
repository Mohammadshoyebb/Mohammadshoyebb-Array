//Single Element in a Sorted Array
// Medium
// Topics
// Companies
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:

// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105




public class SingleElementInSortedArray_leetcode27 {
    /**
     * Finds the single element in a sorted array where every other element appears exactly twice.
     *
     * @param nums The sorted array of integers.
     * @return The single element that appears only once.
     */
    public int singleNonDuplicate(int[] nums) {
        // Initialize left pointer to the start of the array
        int left = 0;
        // Initialize right pointer to the end of the array
        int right = nums.length - 1;
        
        // Perform binary search
        while (left < right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;
            
            // Check if mid is odd
            if (mid % 2 == 1) {
                // If mid is odd, compare with its previous element
                if (nums[mid] == nums[mid - 1]) {
                    // If equal, single element is to the right of mid
                    left = mid + 1;
                } else {
                    // If not equal, single element is to the left of mid
                    right = mid - 1;
                }
            } else {
                // If mid is even, compare with its next element
                if (nums[mid] == nums[mid + 1]) {
                    // If equal, single element is to the right of mid
                    left = mid + 2;
                } else {
                    // If not equal, single element is to the left of mid
                    right = mid;
                }
            }
        }
        
        // At the end, left will point to the single element
        return nums[left];
    }
    
    public static void main(String[] args) {
        SingleElementInSortedArray_leetcode27 solution = new SingleElementInSortedArray_leetcode27();
        
        // Example 1
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Example 1: " + solution.singleNonDuplicate(nums1)); // Output: 2
        
        // Example 2
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println("Example 2: " + solution.singleNonDuplicate(nums2)); // Output: 10
    }
}

