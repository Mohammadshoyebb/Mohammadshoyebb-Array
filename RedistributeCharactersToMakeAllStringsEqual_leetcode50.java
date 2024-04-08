/*
 1897. Redistribute Characters to Make All Strings Equal
Solved
Easy
Topics
Companies
Hint
You are given an array of strings words (0-indexed).

In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].

Return true if you can make every string in words equal using any number of operations, and false otherwise.

 

Example 1:

Input: words = ["abc","aabc","bc"]
Output: true
Explanation: Move the first 'a' in words[1] to the front of words[2],
to make words[1] = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return true.
Example 2:

Input: words = ["ab","a"]
Output: false
Explanation: It is impossible to make all the strings equal using the operation.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
 */



import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual_leetcode50 {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character in all words
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Check if the count of each character is divisible by the number of words
        int wordCount = words.length;
        for (int count : frequencyMap.values()) {
            if (count % wordCount != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RedistributeCharactersToMakeAllStringsEqual_leetcode50 solution = new RedistributeCharactersToMakeAllStringsEqual_leetcode50();

        // Test cases
        String[] words1 = {"abc","aabc","bc"};
        System.out.println("Can make all strings equal for words1: " + solution.makeEqual(words1)); // Output: true

        String[] words2 = {"ab","a"};
        System.out.println("Can make all strings equal for words2: " + solution.makeEqual(words2)); // Output: false
    }
}



//==================ANOTHER FAST METHOD============================================


// class Solution {
//     public boolean makeEqual(String[] words) {
//         int[] frequency = new int[26];
//         for(int i=0;i<words.length;i++){
//             String w = words[i];
//             for(int j=0;j<w.length();j++){

//                 char ch = w.charAt(j);
//                 int index = (int)(ch-'a');

//                 frequency[index]++;
//             }
//         }
//         for(int i=0;i<26;i++){
//             if(frequency[i]%words.length != 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
