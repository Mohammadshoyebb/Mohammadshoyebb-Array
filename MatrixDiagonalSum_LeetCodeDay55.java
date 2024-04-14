/**
 * 1572. Matrix Diagonal Sum
 * Easy
 * 
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 * 
 * Example 1:
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * 
 * Example 2:
 * Input: mat = [[1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1]]
 * Output: 8
 * 
 * Example 3:
 * Input: mat = [[5]]
 * Output: 5
 */
public class MatrixDiagonalSum_LeetCodeDay55 {
    /**
     * Returns the sum of the diagonals of the given square matrix.
     * 
     * @param mat The square matrix.
     * @return The sum of the diagonals.
     */
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        // Sum of the primary diagonal
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
        }

        // Sum of the secondary diagonal
        for (int i = 0; i < n; i++) {
            sum += mat[i][n - i - 1];
        }

        // If matrix size is odd, subtract the intersection element counted twice
        if (n % 2 != 0) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }

    public static void main(String[] args) {
        MatrixDiagonalSum_LeetCodeDay55 solution = new MatrixDiagonalSum_LeetCodeDay55();

        // Test cases
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Diagonal sum for mat1: " + solution.diagonalSum(mat1)); // Output: 25

        int[][] mat2 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println("Diagonal sum for mat2: " + solution.diagonalSum(mat2)); // Output: 8

        int[][] mat3 = {{5}};
        System.out.println("Diagonal sum for mat3: " + solution.diagonalSum(mat3)); // Output: 5
    }
}


//===================================================================================
// class Solution {
//     public int diagonalSum(int[][] mat) {
//        int sum = 0 ;
//        int n = mat.length;

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i==j || i+j == n-1){
//                    sum += mat[i][j];
//                }
//            }
//        }
//        return sum ;
//     }
// }