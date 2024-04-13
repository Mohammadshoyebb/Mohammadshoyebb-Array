/**
 * 242. Valid Anagram
 * Easy
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters.
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
import java.util.Arrays;

public class ValidAnagram_LeetCodeDay54 {
    /**
     * Checks if the given strings are anagrams of each other.
     * 
     * @param s The first string.
     * @param t The second string.
     * @return True if t is an anagram of s, false otherwise.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Check if the sorted character arrays are equal
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        ValidAnagram_LeetCodeDay54 solution = new ValidAnagram_LeetCodeDay54();

        // Test cases
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Is '" + t1 + "' an anagram of '" + s1 + "'? " + solution.isAnagram(s1, t1)); // Output: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println("Is '" + t2 + "' an anagram of '" + s2 + "'? " + solution.isAnagram(s2, t2)); // Output: false
    }
}


// ==================================================================================
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }


//         if (s.length() > 300 && s.charAt(0) == 'h') {
//             return t.charAt(t.length()-1)!='z';
//         } else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
//             return false;
//         }

//         int charCounter[] = new int[26];

//         for (int i = 0; i < s.length(); i++) {
            
//             charCounter[s.charAt(i) - 'a']++;
//             charCounter[t.charAt(i) - 'a']--;
//         }

//         for (int counter : charCounter) {
//             if (counter != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

/*
 * class Solution {
    public boolean isAnagram(String s, String t) {
        int alps[] = new int[26];
        int alpt[] = new int[26];

        for(int i=0; i<s.length(); i++) {
            alps[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            alpt[t.charAt(i)-'a']++;
        }

        boolean anagram = true;
        for(int i=0; i<alps.length && i<alpt.length; i++) {
            if(alps[i] != alpt[i]) {
                anagram = false;
                break;
            }
        }

        return anagram;
    }
}
 */


 //-----------------------------------------------------------------------------------

//  class Solution {
//     public boolean isAnagram(String s, String t) {
//         HashMap<Character , Integer> hm = new HashMap<>();

//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(hm.containsKey(ch)==true){
//                 hm.put(ch,hm.get(ch)+1);
//             }else{
//                 hm.put(ch,1);
//             }
//         }

//          for(int i=0;i<t.length();i++){

//             char ch = t.charAt(i);

//             if(hm.containsKey(ch)==true){
//                 if(hm.get(ch)==1){
//                     hm.remove(ch);
//                 }else{
//                     hm.put(ch,hm.get(ch)-1);
//                 }
//             }else{
//                 return false ;
//             }
//         }

//         if(hm.size()==0){
//             return true;
//         }else{
//             return false;
//         }
//     }
// }