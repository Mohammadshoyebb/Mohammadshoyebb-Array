/*
 287. Find the Duplicate Number
Solved
Medium
Topics
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */




class FindDuplicateNumber_leet41_Important {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Find the meeting point of slow and fast pointers
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Reset one pointer to the beginning and move both pointers one step at a time until they meet
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // The meeting point is the entry point of the cycle (duplicate number)
    }

    public static void main(String[] args) {
        FindDuplicateNumber_leet41_Important solution = new FindDuplicateNumber_leet41_Important();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number in nums1: " + solution.findDuplicate(nums1)); // Output: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number in nums2: " + solution.findDuplicate(nums2)); // Output: 3

        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Duplicate number in nums3: " + solution.findDuplicate(nums3)); // Output: 3
    }
}

//==============================ANOTHER METHOD====================================
//   NOTE this Methiod Changes Original ARRAY

// class Solution {
//     public int findDuplicate(int[] nums) {

//        int x=nums[0];
//        for(int i=0;i<nums.length;i++)
//        {
//         int index=Math.abs(nums[i]);
//         if(nums[index]<0)
//         return index;
//         nums[index]=-nums[index];
//        }
//        return -1;

        
//     }
// }


//ANOTHER METHOD THIS METHOD DOESNOT CHANGE ORIGINAL ARRAY

// class Solution {
//     public int findDuplicate(int[] nums) {

//         int ans = 0 ;

//        for(int i=0;i<nums.length;i++){
//            int ele = nums[i];
//            ele = Math.abs(ele);

//            if(nums[ele]>0){
//                nums[ele]=-nums[ele];
//            }else{
//                ans =  ele ;
//                break;
//            }
//        }

//        for(int i=0;i<nums.length;i++){
//            nums[i]=Math.abs(nums[i]);
//        }

//        return ans ;
//     }
// }


//======================Another Method Using Hashset==============================
// class Solution {
//     public int findDuplicate(int[] nums) {
//     HashSet<Integer> set = new HashSet<>(); 
//     int ans =0;
//     for(int i=0;i<nums.length;i++){
       
//         if(set.contains(nums[i])){
//             ans =  nums[i];
//             break;
//         }

//         else{
//             set.add(nums[i]);
//         }
//     }return ans;
// }
// }


