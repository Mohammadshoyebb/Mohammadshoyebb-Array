public class removeElementsFromArray {
        public static int removeElement(int[] nums, int val) {
             int slowPointer = 0; // Points to the position where non-val elements should be placed
            
            for (int fastPointer = 0; fastPointer < nums.length; fastPointer++) {
                if (nums[fastPointer] != val) {
                    // Found a non-val element, place it at the position pointed by slowPointer
                    nums[slowPointer] = nums[fastPointer];
                    slowPointer++; // Move slowPointer to the next position
                }
            }
            
            return slowPointer; // Number of elements in nums which are not equal to val
       }
       public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,2,2,3,9,0,0,2,2};
        int val =2;
        System.out.println(removeElement(arr,val));
       }
    }
