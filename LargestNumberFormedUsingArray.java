/*
179. Largest Number
Medium

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 10^9
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedUsingArray {
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        
        // Sort the strings using a custom comparator
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Concatenate two strings in two different orders
                String order1 = a + b; // For example, "3" + "30" = "330"
                String order2 = b + a; // For example, "30" + "3" = "303"
                // Compare concatenated strings in descending lexicographic order
                return order2.compareTo(order1);
            }
        });
        
        // If the largest number is 0, return "0"
        if (numsStr[0].equals("0")) {
            return "0";
        }
        
        // Concatenate sorted strings to form the largest number
        StringBuilder sb = new StringBuilder();
        for (String str : numsStr) {
            sb.append(str);
        }
        
        return sb.toString();
    }
    public static void main(String[] args) {
        LargestNumberFormedUsingArray solution = new LargestNumberFormedUsingArray();

        // Example 1
        int[] nums1 = {10, 2};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.largestNumber(nums1));

        // Example 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.largestNumber(nums2));
    }
}

    
    // Alternative method using Lambda expression

    /*
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i]+"";
        }

        Arrays.sort(arr,(s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder("");

        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i]);
        }

        if(sb.charAt(0)=='0'){
            return "0";
        }else{
            return sb.toString();
        }
    }
    */


