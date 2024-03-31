/*
 1046. Last Stone Weight
Solved
Easy
Topics
Companies
Hint
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1
 

Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
 */



import java.util.PriorityQueue;

public class LastStoneWeight_LeetCode42 {
    public int lastStoneWeight(int[] stones) {
        // Initialize a priority queue (max-heap) to store stone weights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all stone weights to the priority queue
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // While there are at least two stones in the queue, smash them together
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // Heaviest stone
            int stone2 = maxHeap.poll(); // Second heaviest stone

            // If the weights of stones are different, update the weight of the heaviest stone
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        // Return the weight of the last remaining stone, or 0 if no stone is left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight_LeetCode42 solution = new LastStoneWeight_LeetCode42();

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Last remaining stone weight: " + solution.lastStoneWeight(stones1)); // Output: 1

        int[] stones2 = {1};
        System.out.println("Last remaining stone weight: " + solution.lastStoneWeight(stones2)); // Output: 1
    }
}
//======================Same Method With Different Style==================================


// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         //max priority queue
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//         for(int ele : stones){ // adding the elements of array to pq
//             pq.add(ele);
//         }

//         while(pq.size()>1){
//             int max = pq.remove();
//             int smax = pq.remove();

//             int nstone = max - smax ;

//             if(nstone!=0){
//                 pq.add(nstone);
//             }
//         }

//         if(pq.size()==0){
//             return 0 ;
//         }else{
//             return pq.remove();
//         }
//     }
// }
