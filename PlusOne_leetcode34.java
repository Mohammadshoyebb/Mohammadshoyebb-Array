/*
 66. Plus One

Easy
Topics
Companies


You are given a large integer represented as an integer array digits, 
where each digits[i] is the ith digit of the integer. The digits are 
ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 
 */



class PlusOne_leetcode34 {
    // Method to increment a large integer represented by an array of digits by one
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // If the last digit is not 9, just increment it by one
        if (digits[n - 1] != 9) {
            digits[n - 1] = digits[n - 1] + 1;
            return digits;
        }

        // If the last digit is 9, propagate the carry
        digits[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        // If carry reaches the most significant digit, create a new array with additional digit
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        PlusOne_leetcode34 solution = new PlusOne_leetcode34();

        // Example cases
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.print("Output for digits1: ");
        printArray(result1);
        // Output: 1 2 4

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.print("Output for digits2: ");
        printArray(result2);
        // Output: 4 3 2 2

        int[] digits3 = {9};
        int[] result3 = solution.plusOne(digits3);
        System.out.print("Output for digits3: ");
        printArray(result3);
        // Output: 1 0

        int[] digits4 = {9, 9, 9, 9, 9, 9, 9};
        int[] result4 = solution.plusOne(digits4);
        System.out.print("Output for digits4: ");
        printArray(result4);
        // Output: 1 0 0 0 0 0 0 0
    }

    // Helper method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
