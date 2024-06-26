/*
  128. Longest Consecutive Sequence
Solved
Medium
Topics
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */






import java.util.HashSet;

public class LongestConsecutiveSequence__leetcode40 {
     public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) { // If num-1 doesn't exist, then start counting the sequence from num
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) { // Count consecutive numbers
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength); // Update maximum length
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence__leetcode40 lcs = new LongestConsecutiveSequence__leetcode40();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence length for nums1: " + lcs.longestConsecutive(nums1)); // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest consecutive sequence length for nums2: " + lcs.longestConsecutive(nums2)); // Output: 9
    }
}


//--------------------Faster METHOD-------------------------------------------

/*
 class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],false);
        }

        for(int key : hm.keySet()){
            if(hm.containsKey(key-1)==false){
                hm.put(key,true);
            }
        }

        int max = 0 ;
        for(int key : hm.keySet()){
            int k=1 ;
            if(hm.get(key)==true){
                while(hm.containsKey(key+k)==true){
                    k++;
                }
            }
            max = Math.max(max,k);
        }
        return max ;
    }
}
 */