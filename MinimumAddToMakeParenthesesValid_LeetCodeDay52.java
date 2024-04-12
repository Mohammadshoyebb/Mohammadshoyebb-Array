/**
 * 921. Minimum Add to Make Parentheses Valid
 * Medium
 * 
 * A parentheses string is valid if and only if:
 * - It is the empty string,
 * - It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * - It can be written as (A), where A is a valid string.
 * 
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * Return the minimum number of moves required to make s valid.
 * 
 * Example 1:
 * Input: s = "())"
 * Output: 1
 * 
 * Example 2:
 * Input: s = "((("
 * Output: 3
 * 
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s[i] is either '(' or ')'.
 */
import java.util.Stack;

public class MinimumAddToMakeParenthesesValid_LeetCodeDay52 {
    /**
     * Calculates the minimum number of moves required to make the given parentheses string valid.
     * 
     * @param s The input parentheses string.
     * @return The minimum number of moves required.
     */
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int moves = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Pair is valid, remove opening parenthesis from stack
                } else {
                    moves++; // No corresponding opening parenthesis found, need to add closing parenthesis
                }
            }
        }
        
        // Remaining opening parentheses in the stack need a corresponding closing parenthesis
        moves += stack.size();
        
        return moves;
    }

    public static void main(String[] args) {
        MinimumAddToMakeParenthesesValid_LeetCodeDay52 solution = new MinimumAddToMakeParenthesesValid_LeetCodeDay52();

        // Test cases
        String s1 = "())";
        System.out.println("Minimum moves for '" + s1 + "': " + solution.minAddToMakeValid(s1)); // Output: 1

        String s2 = "(((";
        System.out.println("Minimum moves for '" + s2 + "': " + solution.minAddToMakeValid(s2)); // Output: 3
    }
}

//====================================================================================
// class Solution {
//     public int minAddToMakeValid(String s) {
        
//         int ans =0 ;
//         int open = 0;
//         int close = 0;
//         for(char c: s.toCharArray()){
//             if(c=='(') open++;
//              else {
//                if(open>0){
//                 open--;
//                } else {
//                 ans++;
//                }
//              }
//         }

//         return ans+open;
//     }
// }