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
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }else if ( nums[0]!=nums[1]){
            return nums[0];
        }else if ( nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }

        int start = 0 ;
        int end = nums.length-1 ;

        while(start<=end){
            int mid = (start + end)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else if ( mid % 2 ==1 ){ // if mid index is odd

                if(nums[mid-1]==nums[mid]){
                    start = mid+1 ;
                }else{
                    end = mid-1 ;
                }
            }else { // if mid index is even
                    if(nums[mid]==nums[mid+1]){
                        start = mid +1 ;
                    }else{
                        end = mid -1 ;
                    }
            }
        }

        return -1 ;
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

