public class BINARY_SEARCH {

    public static void binarySearch(int[] n, int key) {
        int len = n.length;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (n[mid] == key) {
                System.out.println("Element is found at position: " + mid);
                return; // Exit the method if element is found
            }
            if (key < n[mid]) {
                end = mid - 1;
            } else { // Corrected the condition here
                start = mid + 1;
            }
        }
        System.out.println("Element is not present in the array");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 8, 9, 12, 14, 17};
        int key = 8;

        binarySearch(arr, key);
    }
}