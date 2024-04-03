/*
 58. Length of Last Word
Solved
Easy
Topics
Companies
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 */

public class LengthOfLastWord_leetCodeDay45 {
    public int lengthOfLastWord(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Find the index of the last space character
        int lastSpaceIndex = s.lastIndexOf(' ');

        // Return the length of the last word
        return s.length() - lastSpaceIndex - 1;
    }

    public static void main(String[] args) {
        LengthOfLastWord_leetCodeDay45 solution = new LengthOfLastWord_leetCodeDay45();

        // Test cases
        String s1 = "Hello World";
        System.out.println("Length of last word in \"" + s1 + "\": " + solution.lengthOfLastWord(s1)); // Output: 5

        String s2 = "   fly me   to   the moon  ";
        System.out.println("Length of last word in \"" + s2 + "\": " + solution.lengthOfLastWord(s2)); // Output: 4

        String s3 = "luffy is still joyboy";
        System.out.println("Length of last word in \"" + s3 + "\": " + solution.lengthOfLastWord(s3)); // Output: 6
    }
}
