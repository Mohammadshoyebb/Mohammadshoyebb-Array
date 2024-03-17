// 75. Sort Colors
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.




import java.util.Arrays;

public class SortColor__DutchFlag__leetcode28 {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColor__DutchFlag__leetcode28 sorter = new SortColor__DutchFlag__leetcode28();
        
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums1);
        System.out.println("Sorted colors for nums1: " + Arrays.toString(nums1));
        
        int[] nums2 = {2, 0, 1};
        sorter.sortColors(nums2);
        System.out.println("Sorted colors for nums2: " + Arrays.toString(nums2));
    }
}
