/**
 * 125. Valid Palindrome
 * Easy
 * 
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * 
 * Constraints:
 * - 1 <= s.length <= 2 * 10^5
 * - s consists only of printable ASCII characters.
 */

 public class ValidPalindrome_leetCodeDay52 {
    /**
     * Checks if the given string is a valid palindrome.
     * 
     * @param s The input string.
     * @return True if it is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0; // Pointer for the leftmost character
        int right = s.length() - 1; // Pointer for the rightmost character
        
        // Iterate through the string from both ends
        while (left < right) {
            // If characters at the current positions are not equal, return false
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // Move the pointers towards the center
            left++;
            right--;
        }
        
        return true; // Return true if the string is a valid palindrome
    }

    public static void main(String[] args) {
        ValidPalindrome_leetCodeDay52 solution = new ValidPalindrome_leetCodeDay52();

        // Test cases
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Is '" + s1 + "' a palindrome? " + solution.isPalindrome(s1)); // Output: true

        String s2 = "race a car";
        System.out.println("Is '" + s2 + "' a palindrome? " + solution.isPalindrome(s2)); // Output: false

        String s3 = " ";
        System.out.println("Is '" + s3 + "' a palindrome? " + solution.isPalindrome(s3)); // Output: true
    }
}


//+++++++++++++++++++++++++++++++++++FASTER METHOD++++++++++++++++++++++++++++++++++

//class Solution {
//     public boolean isPalindrome(String s) {
//         if(s.length()==1){
//             return true ;
//         }

//         StringBuilder sb = new StringBuilder("");

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);

//             if      (ch>='a' && ch<='z'){sb.append(ch);}
//             else if ( ch>='A' && ch<='Z')
//                 {
//                     ch = (char)(ch-'A'+'a');
//                     sb.append(ch);
//                 }
//             else if ( ch>='0' && ch<='9')
//             {
//                 sb.append(ch);
//             }
//         }

//         int start = 0 ;
//         int end = sb.length()-1;

//         while(start<end){
//             int sChar = sb.charAt(start);
//             int eChar = sb.charAt(end);
//             if(sChar!=eChar){
//                 return false;
//             }
//             start++;
//             end--;
//         }

//         return true ;
//     }
// }


//========================MORE FASTER APPROACH====================================

// class Solution {
//     public boolean isPalindrome(String s) {
//         int start=0, end=s.length()-1;
//         while(start < end){
//             char front=s.charAt(start);
//             char back=s.charAt(end);
//             if(front >= 'A' && front<='Z') front += 32;
//             if(back >= 'A'&& back<='Z') back += 32;
//             if(!(front>='a' && front<='z' || front>='0' && front<='9')){
//                 start++;
//                 continue;
//             }
//             if(!(back>='a' && back<='z' || back>='0' && back<='9')){
//                 end--;
//                 continue;
//             }

//             if(
//                 (front>='a' && front<='z' || front>='0' && front<='9') 
//             && 
//                 (back>='a' && back<='z' || back>='0' && back<='9')
//                 ){
//                 start++;
//                 end--;
//                 if(front != back) return false;
//             }
//         }
//         return true;
//     }
// }

//-------------------------------Different Approach=======================

// class Solution {
//     public boolean isPalindrome(String s) {
//         int frontIndex = 0;
//         int rearIndex = s.length() - 1;
//         char frontChar, rearChar;
//         while(frontIndex < rearIndex) {
//             frontChar = getLowerCaseChar(s.charAt(frontIndex));
//             rearChar = getLowerCaseChar(s.charAt(rearIndex));

//             while(frontIndex < rearIndex &&
//              frontChar == '!') {
//                 frontIndex++;
//                 frontChar = getLowerCaseChar(s.charAt(frontIndex));
//             }

//             while(frontIndex < rearIndex &&
//              rearChar == '!') {
//                 rearIndex--;
//                 rearChar = getLowerCaseChar(s.charAt(rearIndex));
//             }

//             if(frontIndex == rearIndex) {
//                 return true;
//             } else if(frontChar != rearChar) {
//                 return false;
//             }
//             frontIndex++;
//             rearIndex--;
//         }

//         return true;
//     }

//     private char getLowerCaseChar(char c) {
//         if(c >= 'A' && c <= 'Z') {
//             return (char) (c + ('a' - 'A'));
//         }

//         if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
//             return c;
//         }

//         return '!';
//     }
// }