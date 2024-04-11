
/**
 * 20. Valid Parentheses
 * Easy
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Constraints:
 * - 1 <= s.length <= 104
 * - s consists of parentheses only '()[]{}'.
 */
import java.util.Stack;

public class ValidParentheses_leetCodeDay53 {
    /**
     * Checks if the given string contains valid parentheses.
     * 
     * @param s The input string.
     * @return True if the string contains valid parentheses, false otherwise.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses_leetCodeDay53 solution = new ValidParentheses_leetCodeDay53();

        // Test cases
        String s1 = "()";
        System.out.println("Is '" + s1 + "' valid? " + solution.isValid(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println("Is '" + s2 + "' valid? " + solution.isValid(s2)); // Output: true

        String s3 = "(]";
        System.out.println("Is '" + s3 + "' valid? " + solution.isValid(s3)); // Output: false
    }
}

//========================ANOTHER METHOD++++++++++++++++++++++++++++++++++++
// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<Character>();
//         for(char c: s.toCharArray()){
//             if(c=='(')
//             stack.push(')');
//             else if(c=='{')
//             stack.push('}');
//             else if(c=='[')
//             stack.push(']');
//             else if(stack.isEmpty() || stack.pop() != c)
//             return false;
//         }
//         return stack.isEmpty();
//     }
// 


//=========================ANOTHER METHOD+++++++++++++++++++++++++++++++++++++++++++++

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (char c : s.toCharArray()) {
//             if ((c == '(') || (c == '{') || (c == '[')) {
//                 stack.push(c);
//             } else {
//                 if (stack.isEmpty() || !isValidPair(stack.pop(), c)) {
//                     return false;
//                 }

//             }
//         }
//         return stack.isEmpty();
//     }

//     private boolean isValidPair(char left, char right) {
//         return (left=='(' && right==')') || (left=='{' && right=='}') || (left=='[' && right==']');

//     }
// }