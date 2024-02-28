public class MissingElementInArray {
        public static int missingNumber(int[] nums) {
       
      int n = nums.length;
            
            // Calculate the expected sum if all numbers were present
            int expectedSum = n * (n + 1) / 2;
            
            // Calculate the actual sum of numbers in the array
            int actualSum = 0;
            for (int num : nums) {
                actualSum += num;
            }
            
            // The difference between expected and actual sum is the missing number
            return expectedSum - actualSum;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,0};
        System.out.println(missingNumber(nums));
    }
}

