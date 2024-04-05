/*
 151. Reverse Words in a String
Medium
Topics
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */


public class ReverseWordsInString {
    public String reverseWords(String s) {
        // Split the string by spaces into an array of words
        String[] words = s.trim().split("\\s+");
        
        // Create a StringBuilder to construct the reversed string
        StringBuilder sb = new StringBuilder();
        
        // Iterate over the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Append each word to the StringBuilder
            sb.append(words[i]);
            
            // Append a space if it's not the last word
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        // Convert the StringBuilder to a string
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();

        // Test cases
        String s1 = "the sky is blue";
        System.out.println("Reversed words of \"" + s1 + "\": " + solution.reverseWords(s1)); // Output: "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println("Reversed words of \"" + s2 + "\": " + solution.reverseWords(s2)); // Output: "world hello"

        String s3 = "a good   example";
        System.out.println("Reversed words of \"" + s3 + "\": " + solution.reverseWords(s3)); // Output: "example good a"
    }
}
