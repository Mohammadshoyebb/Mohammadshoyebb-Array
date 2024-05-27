/*
 * Optimized Array Cleanup

Accuracy: 0.0%

Submissions: 0

Points: 25

Geek has been given an array arr[] of size n by his teacher. His task is to make the array empty using a specific operation. In each operation, Geek can select a subsequence from the array
such that all elements in that subsequence are distinct. The goal is to empty the array using the minimum number of such operations.

Example 1:

Input :
1=5

arr=[1,2,3,1,2]
Output:

2

Explanation:
In the first move, Geek selects the elements at indices 1, 2, and 3 and applies the operation.The array then becomes [1, 2].
In the Second move, Geek selects the elements at indices 1 and 2 and applies the operation again, effectively emptying the array.
Thus, Geek accomplishes the task in a total of 2 moves.

Example 2:

Input :
=3

arr=[1,1,1]
Output:
3

Explanation:
Geek requires a total of 3 moves to empty the array. In each move, Geek removes an element located at index 1.
This process repeats until the array is empty.

Your Task:
You don't need to read input or print anything. Your task is to complete the function minMoves() which takes an integer n and an integer array arr[] as input parameters and return an
integer respresenting the minimum operations reqired to make the array empty.

Constraints:
1 <= n <= 105
1 <= arr[i] <= 109
 */


 
import java.util.HashMap;

public class GeekArrayOperations {
    public static int minMoves(int n, int[] arr) {
        // Create a hashmap to store the frequency of each element
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        // Find the maximum frequency
        int maxFreq = 0;
        for (int freq : frequency.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        // The minimum number of moves is the maximum frequency found
        return maxFreq;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 2};
        int n1 = arr1.length;
        System.out.println(minMoves(n1, arr1)); // Output: 2
        
        int[] arr2 = {1, 1, 1};
        int n2 = arr2.length;
        System.out.println(minMoves(n2, arr2)); // Output: 3
    }
}
