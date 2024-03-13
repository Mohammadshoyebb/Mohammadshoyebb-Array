// Define a function twoSum that takes an array of integers (numbers) and a target integer as input
public static int[] twoSum(int[] numbers, int target) {
    // Initialize two pointers: left and right, pointing to the beginning and end of the array respectively
    int left = 0, right = numbers.length - 1;
    
    // Iterate until the left pointer is less than the right pointer
    while (left < right) {
        // Calculate the sum of the elements pointed to by the left and right pointers
        int currentSum = numbers[left] + numbers[right];
        
        // Check if the current sum equals the target
        if (currentSum == target) {
            // If so, return the indices of the two elements (adjust indices to be 1-indexed)
            return new int[]{left + 1, right + 1};
        } 
        // If the current sum is less than the target, move the left pointer to the right
        else if (currentSum < target) {
            left++;
        } 
        // If the current sum is greater than the target, move the right pointer to the left
        else {
            right--;
        }
    }
    
    // If no solution found, return [-1, -1]
    return new int[]{-1, -1};
}
