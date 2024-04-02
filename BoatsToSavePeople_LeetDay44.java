/*
 881. Boats to Save People
Solved
Medium
Topics
Companies
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
 */


import java.util.Arrays;

public class BoatsToSavePeople_LeetDay44 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {
        BoatsToSavePeople_LeetDay44 solution = new BoatsToSavePeople_LeetDay44();

        int[] people1 = {1, 2};
        int limit1 = 3;
        System.out.println("Minimum number of boats: " + solution.numRescueBoats(people1, limit1)); // Output: 1

        int[] people2 = {3, 2, 2, 1};
        int limit2 = 3;
        System.out.println("Minimum number of boats: " + solution.numRescueBoats(people2, limit2)); // Output: 3

        int[] people3 = {3, 5, 3, 4};
        int limit3 = 5;
        System.out.println("Minimum number of boats: " + solution.numRescueBoats(people3, limit3)); // Output: 4
    }
}

// -------------------------------Simple way----------------------------------
// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         Arrays.sort(people);
//         int start = 0;
//         int end = people.length-1;
//         int count = 0;
//         while(start<=end){
//             if(people[start]+people[end]<=limit){
//                 start++;
//                 end--;
//             }
//             else{
//                 end--;
//             }
//             count++;
//         }
//         return count;
//     }
// }



// ---------------------------- EXPLANATION ----------------------------------------



// Example:
// Suppose we have people = [3, 5, 3, 4] and limit = 5.

// Code Explanation:
// We first sort the people array in ascending order: people = [3, 3, 4, 5].
// We initialize two pointers, left pointing to the start of the array and right pointing to the end of the array.
// We iterate through the array using these pointers:
// If the sum of weights of the people at left and right is less than or equal to the limit, we increment left (as they can fit in the boat together).
// In every iteration, we decrement right and increment the count of boats required.
// We continue this process until left crosses over right.
// Detailed Steps:
// Initially, left = 0 and right = 3.
// We check if people[0] + people[3] = 3 + 5 = 8 is less than or equal to the limit (5). Since it's not, we decrement right to 2.
// Now, left = 0 and right = 2.
// Since people[0] + people[2] = 3 + 4 = 7 is less than or equal to limit (5), we increment left to 1.
// Now, left = 1 and right = 2.
// Since people[1] + people[2] = 3 + 4 = 7 is less than or equal to limit (5), we increment left to 2.
// Now, left = 2 and right = 2.
// Since people[2] + people[2] = 4 + 4 = 8 is not less than or equal to limit (5), we just decrement right to 1.
// Now, left = 2 and right = 1.
// Since left > right, the loop ends.
// Result:
// The minimum number of boats required to save all the people is 4, which is the output of the function.