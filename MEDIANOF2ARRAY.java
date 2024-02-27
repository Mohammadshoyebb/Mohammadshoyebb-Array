// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

public class MEDIANOF2ARRAY {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] mergedArray = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Merge until one of the arrays is exhausted
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1
        while (i < m) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2
        while (j < n) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static double findMedian(int[] mergedArray) {
        int length = mergedArray.length;
        if (length % 2 == 0) {
            return (mergedArray[length / 2 - 1] + mergedArray[length / 2]) / 2.0;
        } else {
            return mergedArray[length / 2];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] mergedArray = mergeArrays(arr1, arr2);

        // Print the merged array
        System.out.print("Merged Array: ");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }

        // Find and print the median of the merged array
        double median = findMedian(mergedArray);
        System.out.println("\nMedian of the merged array: " + median);
    }
}