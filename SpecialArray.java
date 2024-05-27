/**
 * 1608. Special Array With X Elements Greater Than or Equal X
 * Easy
 * 
 * You are given an array nums of non-negative integers. nums is considered special
 * if there exists a number x such that there are exactly x numbers in nums that are
 * greater than or equal to x.
 * 
 * Notice that x does not have to be an element in nums.
 * 
 * Return x if the array is special, otherwise, return -1. It can be proven that if 
 * nums is special, the value for x is unique.
 * 
 * Example 1:
 * Input: nums = [3,5]
 * Output: 2
 * Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
 * 
 * Example 2:
 * Input: nums = [0,0]
 * Output: -1
 * Explanation: No numbers fit the criteria for x.
 * If x = 0, there should be 0 numbers >= x, but there are 2.
 * If x = 1, there should be 1 number >= x, but there are 0.
 * If x = 2, there should be 2 numbers >= x, but there are 0.
 * x cannot be greater since there are only 2 numbers in nums.
 * 
 * Example 3:
 * Input: nums = [0,4,3,0,4]
 * Output: 3
 * Explanation: There are 3 values that are greater than or equal to 3.
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */

 import java.util.Arrays;

 public class SpecialArray {
 
     // Fastest solution using cumulative sum approach
     public int specialArray(int[] nums) {
         int n = nums.length;
         int[] count = new int[n + 1];
 
         // Step 1: Fill the count array
         for (int num : nums) {
             if (num >= n) {
                 count[n]++;
             } else {
                 count[num]++;
             }
         }
 
         // Dry run example: nums = [0, 4, 3, 0, 4]
         // count array: [2, 0, 0, 1, 2, 0]
         // Explanation:
         // 0 -> count[0] = 2 (two 0's)
         // 4 -> count[4] = 2 (two 4's)
         // 3 -> count[3] = 1 (one 3)
 
         // Step 2: Calculate cumulative sum from the end
         int cumulativeSum = 0;
         for (int i = n; i >= 0; i--) {
             cumulativeSum += count[i];
             if (cumulativeSum == i) {
                 return i;
             }
         }
 
         // Dry run example: nums = [0, 4, 3, 0, 4]
         // cumulativeSum array from the end:
         // cumulativeSum += count[5] (cumulativeSum = 0)
         // cumulativeSum += count[4] (cumulativeSum = 2)
         // cumulativeSum += count[3] (cumulativeSum = 3) (matches i = 3, return 3)
 
         // Step 3: If no special x is found, return -1
         return -1;
     }
 
     // Solution using sorting (for completeness)
     public int specialArrayWithSorting(int[] nums) {
         Arrays.sort(nums);
         int n = nums.length;
 
         // Dry run example: nums = [0, 4, 3, 0, 4] after sorting
         // nums = [0, 0, 3, 4, 4]
 
         for (int x = 1; x <= n; x++) {
             int count = 0;
             for (int num : nums) {
                 if (num >= x) {
                     count++;
                 }
             }
             if (count == x) {
                 return x;
             }
         }
 
         // Dry run example: nums = [0, 4, 3, 0, 4]
         // x = 1, count = 4 (>=1)
         // x = 2, count = 4 (>=2)
         // x = 3, count = 3 (>=3) (matches x, return 3)
 
         return -1;
     }
 
     // Solution using binary search
     public int specialArrayWithBinarySearch(int[] nums) {
         Arrays.sort(nums);
         int n = nums.length;
 
         int left = 0;
         int right = n;
 
         // Dry run example: nums = [0, 4, 3, 0, 4] after sorting
         // nums = [0, 0, 3, 4, 4]
 
         while (left <= right) {
             int mid = left + (right - left) / 2;
             int count = 0;
 
             for (int num : nums) {
                 if (num >= mid) {
                     count++;
                 }
             }
 
             if (count == mid) {
                 return mid;
             } else if (count < mid) {
                 right = mid - 1;
             } else {
                 left = mid + 1;
             }
         }
 
         // Dry run example: nums = [0, 4, 3, 0, 4]
         // left = 0, right = 5, mid = 2, count = 3 (>=2) -> right = 1
         // left = 0, right = 1, mid = 0, count = 5 (>=0) -> left = 1
         // left = 1, right = 1, mid = 1, count = 4 (>=1) -> right = 0
 
         return -1;
     }
 
     public static void main(String[] args) {
         SpecialArray solution = new SpecialArray();
 
         // Test cases
         System.out.println(solution.specialArray(new int[]{3, 5}));  // Output: 2
         System.out.println(solution.specialArray(new int[]{0, 0}));  // Output: -1
         System.out.println(solution.specialArray(new int[]{0, 4, 3, 0, 4}));  // Output: 3
 
         System.out.println(solution.specialArrayWithSorting(new int[]{3, 5}));  // Output: 2
         System.out.println(solution.specialArrayWithSorting(new int[]{0, 0}));  // Output: -1
         System.out.println(solution.specialArrayWithSorting(new int[]{0, 4, 3, 0, 4}));  // Output: 3
 
         System.out.println(solution.specialArrayWithBinarySearch(new int[]{3, 5}));  // Output: 2
         System.out.println(solution.specialArrayWithBinarySearch(new int[]{0, 0}));  // Output: -1
         System.out.println(solution.specialArrayWithBinarySearch(new int[]{0, 4, 3, 0, 4}));  // Output: 3
     }
 }
 