/*
Problem Statement:
Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.


Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
Example 2:

Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
Example 3:

Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
 

Constraints:

1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums is sorted in a non-decreasing order.
 

Follow up: Can you solve the problem in O(log(n)) time complexity?


*/



class MaximumCountOfPositiveAndNegativeInteger_LeetCode33 {
    // Method to calculate the maximum count of positive or negative integers
    public int maximumCount(int[] nums) {
        // Find the index of the last negative number
        int lastnegIndex = lastNegative(nums) + 1;
        // Find the index of the first positive number
        int firtposIndex = nums.length - firstPositive(nums);

        // Return the maximum count between positive and negative integers
        return Math.max(lastnegIndex , firtposIndex);
    }

    // Method to find the index of the last occurrence of a negative number using binary search
    public int lastNegative(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // Binary search
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < 0) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // Method to find the index of the first occurrence of a positive number using binary search
    public int firstPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        // Binary search
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        MaximumCountOfPositiveAndNegativeInteger_LeetCode33 solution = new MaximumCountOfPositiveAndNegativeInteger_LeetCode33();

        // Example cases
        int[] nums1 = {-2, -1, -1, 1, 2, 3};
        System.out.println("Output for nums1: " + solution.maximumCount(nums1)); // Output: 3

        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println("Output for nums2: " + solution.maximumCount(nums2)); // Output: 3

        int[] nums3 = {5, 20, 66, 1314};
        System.out.println("Output for nums3: " + solution.maximumCount(nums3)); // Output: 4
    }
}
