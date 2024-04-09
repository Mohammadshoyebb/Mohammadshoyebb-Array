/**
 * 1446. Consecutive Characters
 * Easy
 * 
 * The power of the string is the maximum length of a non-empty substring that contains only one unique character.
 * 
 * Given a string s, return the power of s.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * 
 * Example 2:
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * 
 * Constraints:
 * - 1 <= s.length <= 500
 * - s consists of only lowercase English letters
 */

 public class ConsecutiveCharacter_leetCodeDay51 {
    /**
     * Calculates the maximum consecutive character power in the given string.
     * 
     * @param s The input string.
     * @return The maximum consecutive character power.
     */
    public int maxPower(String s) {
        int maxPower = 1; // Initialize the maximum power to 1
        int currentPower = 1; // Initialize the current consecutive character power to 1
        
        // Iterate through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // If the current character is the same as the previous character
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentPower++; // Increment the current consecutive character power
                maxPower = Math.max(maxPower, currentPower); // Update the maximum power if needed
            } else {
                currentPower = 1; // Reset the current consecutive character power
            }
        }
        
        return maxPower; // Return the maximum consecutive character power
    }

    public static void main(String[] args) {
        ConsecutiveCharacter_leetCodeDay51 solution = new ConsecutiveCharacter_leetCodeDay51();

        // Test cases
        String s1 = "leetcode";
        System.out.println("Power of '" + s1 + "': " + solution.maxPower(s1)); // Output: 2

        String s2 = "abbcccddddeeeeedcba";
        System.out.println("Power of '" + s2 + "': " + solution.maxPower(s2)); // Output: 5

        String s3 = "aabbbccc";
        System.out.println("Power of '" + s3 + "': " + solution.maxPower(s3)); // Output: 3
    }
}


//===========================Another Method===========================================


// class Solution {
//     public int maxPower(String s) {
//         int max = 1;
//         int count = 1 ;

//         for(int i=1 ;i<s.length();i++){
//             char curr = s.charAt(i);
//             char pre = s.charAt(i-1);

//             if(curr==pre ){
//                 count++;
//             }else{
//                 max = Math.max(max,count);
//                 count = 1 ;
//             }
//         }
//          max = Math.max(max,count);
//          return max ;
//     }
// }