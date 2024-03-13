// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.
 

// Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

import java.util.Arrays;
class SortedArraySquare {
    // Method to sort the squares of numbers in a sorted array
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;                // Pointer for the left end of the array
        int right = n - 1;           // Pointer for the right end of the array
        int index = n - 1;           // Index to fill the result array
        
        // Using two pointers to traverse the array and fill the result array with sorted squares
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];     // Square of the number pointed by left pointer
            int rightSquare = nums[right] * nums[right];  // Square of the number pointed by right pointer
            
            // Compare the squared values and fill the result array accordingly
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;    // Put the squared value at the end of the result array
                left++;                          // Move the left pointer to the right
            } else {
                result[index--] = rightSquare;   // Put the squared value at the end of the result array
                right--;                         // Move the right pointer to the left
            }
        }
        
        return result;   // Return the sorted array of squares
    }

    public static void main(String[] args) {
        SortedArraySquare solution = new SortedArraySquare();
        
        // Example usage:
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7, -3, 2, 3, 11};

        int[] result1 = solution.sortedSquares(nums1);
        int[] result2 = solution.sortedSquares(nums2);

        // Output the sorted squares for each input array
        System.out.println("Sorted squares for nums1: " + Arrays.toString(result1)); // Output: [0, 1, 9, 16, 100]
        System.out.println("Sorted squares for nums2: " + Arrays.toString(result2)); // Output: [4, 9, 9, 49, 121]
    }
}