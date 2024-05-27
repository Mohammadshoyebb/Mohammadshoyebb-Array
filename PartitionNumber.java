public class PartitionNumber {
    public static void main(String[] args) {
        int N = 9;
        int K = 5;
        System.out.println(countPartitions(N, K));
    }
    
    public static int countPartitions(int N, int K) {
        int[][][] dp = new int[N + 1][K + 1][N + 1];

        // Base case: one way to partition 0 into 0 groups
        for (int m = 0; m <= N; m++) {
            dp[0][0][m] = 1;
        }

        // Fill the dp table
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                for (int m = 1; m <= N; m++) {
                    if (n >= m) {
                        dp[n][k][m] = dp[n][k][m-1] + dp[n-m][k-1][m];
                    } else {
                        dp[n][k][m] = dp[n][k][m-1];
                    }
                }
            }
        }

        // The answer is dp[N][K][1..N], i.e., sum of dp[N][K][1], dp[N][K][2], ..., dp[N][K][N]
        int result = 0;
        for (int m = 1; m <= N; m++) {
            result += dp[N][K][m];
        }

        return result;
    }
}
