/**
 * 867. Transpose Matrix
 * Easy
 * 
 * Given a 2D integer array matrix, return the transpose of matrix.
 * 
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * 
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * 
 * Example 2:
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * 
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 1000
 * - 1 <= m * n <= 105
 * - -109 <= matrix[i][j] <= 109
 */
public class TransposeMatrix_LeetCodeDay56 {
    /**
     * Returns the transpose of the given matrix.
     * 
     * @param matrix The input matrix.
     * @return The transpose of the matrix.
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposeMatrix = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }

        return transposeMatrix;
    }

    public static void main(String[] args) {
        TransposeMatrix_LeetCodeDay56 solution = new TransposeMatrix_LeetCodeDay56();

        // Test cases
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result1 = solution.transpose(matrix1);
        System.out.println("Transpose of matrix1:");
        for (int[] row : result1) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] result2 = solution.transpose(matrix2);
        System.out.println("Transpose of matrix2:");
        for (int[] row : result2) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
