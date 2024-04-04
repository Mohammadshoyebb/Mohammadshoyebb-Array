/*
 316. Remove Duplicate Letters
Solved
Medium
Topics
Companies
Hint
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Create a boolean array to track if a character is present in the stack
        boolean[] inStack = new boolean[26];
        
        // Create a count array to store the frequency of each character
        int[] count = new int[26];
        
        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        // Iterate through the string
        for (char ch : s.toCharArray()) {
            // Decrement the count of the current character
            count[ch - 'a']--;
            
            // Skip if the character is already in the stack
            if (inStack[ch - 'a']) continue;
            
            // Pop characters from the stack if the current character is smaller and there are more occurrences of the popped character later in the string
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            // Push the current character into the stack
            stack.push(ch);
            inStack[ch - 'a'] = true;
        }
        
        // Convert the stack to a string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters solution = new RemoveDuplicateLetters();

        // Test cases
        String s1 = "bcabc";
        System.out.println("After removing duplicate letters from \"" + s1 + "\": " + solution.removeDuplicateLetters(s1)); // Output: "abc"

        String s2 = "cbacdcbc";
        System.out.println("After removing duplicate letters from \"" + s2 + "\": " + solution.removeDuplicateLetters(s2)); // Output: "acdb"
    }
}

